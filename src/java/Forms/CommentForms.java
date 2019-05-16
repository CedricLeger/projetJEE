/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Bean.Commentaire;
import Bean.Utilisateur;
import Bean.Video;
import Dao.DaoCommentaire;
import Dao.DaoUtilisateur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sayoy
 */
public class CommentForms {
    
     private static final String TEXT_COMMENT = "text_comment";
    
    private String result;
    private final Map<String, String> errors = new HashMap<>();
    private final ArrayList<Commentaire> retObj = new ArrayList<>();
    DaoCommentaire daocomment = new DaoCommentaire();
  

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }


    public Commentaire creationComment(HttpServletRequest request, HttpSession session) {
        /* Récupération des champs du formulaire */
        String text_comment = getParamValue(request,TEXT_COMMENT );
        
        Commentaire comment = new Commentaire();
        comment.setText_comment(text_comment);

        // Utilisateur en session
        session = request.getSession();
        //session.getAttribute(Utilisateur);
        Utilisateur user = (Utilisateur)session.getAttribute("sessionUtilisateur");
        System.out.println(user);
       //video.setFk_id_utilisateur(session.);
       
        /* Validation du champ email. */
        try {
        validateText(text_comment);
        } catch (Exception e) {
            setError(TEXT_COMMENT, e.getMessage());
        }
        comment.setText_comment(text_comment);
          try {
        //validateStatut(user);
        } catch (Exception e) {
            setError(TEXT_COMMENT, e.getMessage());
        }
        if (errors.isEmpty()) {
            putCommentInDb(comment);
            result = "commentaire soumis";
        } else {
            result = "Échec";
        }
        return comment;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validateText(String text_comment)throws Exception {
        
        if ("".equals(text_comment)) {
            throw new Exception("Merci de saisir votre commentaire");
       
        }
    }
    private void validateStatut(Utilisateur user,Commentaire comment,Video video) throws Exception
    {
        DaoUtilisateur daouser = new DaoUtilisateur();
        DaoCommentaire daocomment= new DaoCommentaire();
         if ("supprimé".equals(daouser.findStatut(user.getMail()))) {
             if(user.getId_utilisateur()==video.getFk_id_utilisateur() && video.getId_video()==comment.getId_video()){
                    daocomment.updateAllComment(user);
                   throw new Exception("Cet utilisateur est supprimé donc commentaire modifié");
             }
          

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

     private void putCommentInDb(Commentaire comment) {
     
        
        daocomment.create(comment);

        }
     
     /**
      * Supprime une video 
      * @param video 
      */
     
     private void deleteComment(Commentaire comment)
     {
         daocomment.delete(comment);
     }
    
     
     /**
      * recupere toutes les videos 
      */
     private void findComment()
     {
         retObj.add((Commentaire) daocomment.findAll());
     }
     //fonction pour changer la valeur de report d'un commentaire non signalé
     private void reportComment(Commentaire comment){
         
         daocomment.find(comment.getId_comment());
         daocomment.update(comment);
         
     }
     
    
}
