/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Sandra
 */
public class Video {
    private int pk_id_video, positive_vote, negative_vote;
    private String titre_video, descrption_video;
    private double score;
    private int fk_id_utilisateur;

    public Video() {
    }

    
    public Video(int pk_id_video, int positive, int negative, String titre_video, String descrption_video, double score, int fk_id_utilisateur) {
        this.pk_id_video = pk_id_video;
        this.positive_vote = positive_vote;
        this.negative_vote = negative_vote;
        this.titre_video = titre_video;
        this.descrption_video = descrption_video;
        this.score = score;
        this.fk_id_utilisateur = fk_id_utilisateur;
    }

    
    
    
    
    
    public String getTitre_video() {
        return titre_video;
    }

    public void setTitre_video(String titre_video) {
        this.titre_video = titre_video;
    }

    public String getDescrption_video() {
        return descrption_video;
    }

    public void setDescrption_video(String descrption_video) {
        this.descrption_video = descrption_video;
    }

   

    
    
    
    public int getId_video() {
        return pk_id_video;
    }

    public void setId_video(int pk_id_video) {
        this.pk_id_video = pk_id_video;
    }

    public int getPositive() {
        return positive_vote;
    }

    public void setPositive(int positive) {
        this.positive_vote = positive;
    }

    public int getNegative() {
        return negative_vote;
    }

    public void setNegative(int negative) {
        this.negative_vote = negative;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId_utilisateur() {
        return fk_id_utilisateur;
    }

    public void setId_utilisateur(int fk_id_utilisateur) {
        this.fk_id_utilisateur = fk_id_utilisateur;
    }
    
    
}
