/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import Bean.Commentaire;
import Bean.Utilisateur;
import Bean.Video;
import Dao.DaoUtilisateur;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class ConnectionForms {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private String result;
    private final Map<String, String> errors = new HashMap<>();
    DaoUtilisateur daouser = new DaoUtilisateur();
    Utilisateur user = new Utilisateur();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    /**
     * Méthode de validation du formulaire.
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public Utilisateur connectUtilisateur(HttpServletRequest request) throws Exception {
        /* Récupération des champs du formulaire */
        String email = getParamValue(request, EMAIL);
        String pwd = getParamValue(request, PASSWORD);
        
        /* Validation du champ email. */
        try {
            validateEmail(email);
        } catch (Exception e) {
            setError(EMAIL, e.getMessage());
        }
        user.setMail(email);
        /* Validation du champ mot de passe. */
        try {
            validatePassword(pwd);
            verifierPassword(email,pwd);
        } catch (Exception e) {
            setError(PASSWORD, e.getMessage());
        }
      
        user.setPassword(pwd);
        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }
        return user;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validateEmail(String email)
            throws Exception {
        if (email == null) {
            throw new Exception("Merci de saisir une adresse mail.");
        } else if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception(
                    "Merci de saisir une adresse mail valide. ");
        } else if(!daouser.findMail(email))
        {
            throw new Exception("Cette adresse n'existe pas veuillez crée une compte avant de vous connecter");
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validatePassword(String password)
            throws Exception {
        if (password != null) {
            if (password.length() < 3) {
                throw new Exception(
                        "Le mot de passe doit contenir au moins 3 caractères.");
            }
            
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
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
     private void verifierPassword(String email,String password) throws Exception{
         
         if(!daouser.findlog(email,password)){
            
           throw new Exception("Votre mot de passe ne correspond pas votre email");
         }
         }
     
     
     }

