/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import Bean.Video;
import Dao.DaoVideo;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */

public class VideoForms {
    
    private static final String LIEN = "lien";
    private static final String TITRE = "titre";
    private static final String DESCRIPTION = "description";
    
    private String result;
    private final Map<String, String> errors = new HashMap<>();
    
    DaoVideo daovideo = new DaoVideo();
  

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }


    public Video creationVideo(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String lien = getParamValue(request,LIEN );
        String titre= getParamValue(request, TITRE);
        String description= getParamValue(request, DESCRIPTION);
        
        Video video = new Video();
        video.setLien_video(lien);
        video.setTitre_video(titre);
        video.setDescription_video(description);
        // Utilisateur en session
        video.setFk_id_utilisateur(1);
       
        /* Validation du champ email. */
        try {
        validateLien(lien);
        } catch (Exception e) {
            setError(LIEN, e.getMessage());
        }
        video.setLien_video(lien);
        /* Validation du champ mot de passe. */
        try {
            validateTitre(titre);
            //verifierPassword(email,pwd);
        } catch (Exception e) {
            setError(TITRE, e.getMessage());
        }
        video.setTitre_video(titre);
    
        try {
            validateDescription(description);
          
        } catch (Exception e) {
            setError(DESCRIPTION, e.getMessage());
        }
        video.setDescription_video(description);
        if (errors.isEmpty()) {
            putVideoInDb(video);
            result = "Votre video a bien été enregistré";
        } else {
            result = "Échec de 'enregistrement de votre video";
        }
        return video;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validateLien(String lien)throws Exception {
        
        if ("".equals(lien)) {
            throw new Exception("Merci de saisir un lien");
       
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validateTitre(String titre)throws Exception {
      if ("".equals(titre)) {
            throw new Exception("Merci de saisir un titre");
      }
      if (titre.length() > 25) {
                throw new Exception(
                        "Le titre doit contenir au maximum 25 caractères.");
            }
            
       
    }

    /*
* Ajoute un message correspondant au champ spécifié à la map des
erreurs.
     */
    private void setError(String field, String message) {
        errors.put(field, message);
    }

    /*
* Méthode utilitaire qui retourne null si un champ est vide, et son
contenu
* sinon.
     */
    private static String getParamValue(HttpServletRequest request, String paramKey) {
        String value = request.getParameter(paramKey);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value.trim();
        }
    }
     private void validateDescription(String description) throws Exception{
         
          if ("".equals(description)) {
            throw new Exception("Merci de saisir une description");
          
         }
          else if(description.length() > 500)
          {
              throw new Exception("Votre description est trop longue");
          }
     }
     private void putVideoInDb(Video video) {
     
        
        daovideo.create(video);

        }
    }



