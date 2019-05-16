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
    private Integer pk_id_utilisateur;
    private String mail, password,statut="actif", pseudo;

    public Utilisateur() {
    }

    
    
    public Utilisateur(int pk_id_utilisateur, String mail, String password, String pseudo) {
        this.pk_id_utilisateur = pk_id_utilisateur;
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
    }

    public Utilisateur(int pk_id_utilisateur, String mail, String password, String pseudo, String statut) {
        this.pk_id_utilisateur = pk_id_utilisateur;
        this.mail = mail;
        this.password = password;
        this.pseudo = pseudo;
        this.statut = statut;
    }

    
    
    
    public Integer getId_utilisateur() {
        return pk_id_utilisateur;
    }

    public void setId_utilisateur(Integer pk_id_utilisateur) {
        this.pk_id_utilisateur = pk_id_utilisateur;
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


    @Override
    public String toString() {
        return "Utilisateur{" + "pk_id_utilisateur=" + pk_id_utilisateur + ", mail=" + mail + ", password=" + password + ", statut=" + statut + ", pseudo=" + pseudo + '}';
    }
    


    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    
}
