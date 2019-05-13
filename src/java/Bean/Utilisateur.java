/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

/**
 *
 * @author Expression Cedric is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Utilisateur {
    private Integer id_utilisateur;
    private String mail, password,statut="actif", pseudo;
    private boolean admin=false;

    public Utilisateur() {
    }

    
    
    public Utilisateur(int id_utilisateur, String mail, String password, String pseudo) {
        this.id_utilisateur = id_utilisateur;
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
    }

    public Utilisateur(int id_utilisateur, String mail, String password, String pseudo, Boolean admin, String statut) {
        this.id_utilisateur = id_utilisateur;
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
        this.admin = admin;
        this.statut = statut;
    }

    
    
    
    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    
}
