/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;

/**
 *
 * @author Sandra
 */
public class Video {
    private int pk_id_video, positive_vote, negative_vote;
    private String titre_video, description_video, lien_video;
    private double score;
    private int fk_id_utilisateur;
    private Date date_video;
    
    public Video() {
    }

    public Video(int pk_id_video, int positive_vote, int negative_vote, String titre_video, String description_video, String lien_video, double score, Date date_video) {
        this.pk_id_video = pk_id_video;
        this.positive_vote = positive_vote;
        this.negative_vote = negative_vote;
        this.titre_video = titre_video;
        this.description_video = description_video;
        this.lien_video = lien_video;
        this.score = score;
        this.date_video = date_video;
    }

    public Video(int pk_id_video, int positive_vote, int negative_vote, String titre_video, String description_video, String lien_video, double score, int fk_id_utilisateur, Date date_video) {
        this.pk_id_video = pk_id_video;
        this.positive_vote = positive_vote;
        this.negative_vote = negative_vote;
        this.titre_video = titre_video;
        this.description_video = description_video;
        this.lien_video = lien_video;
        this.score = score;
        this.fk_id_utilisateur = fk_id_utilisateur;
        this.date_video = date_video;
    }

    

    public int getPk_id_video() {
        return pk_id_video;
    }

    public void setPk_id_video(int pk_id_video) {
        this.pk_id_video = pk_id_video;
    }

    public int getPositive_vote() {
        return positive_vote;
    }

    public void setPositive_vote(int positive_vote) {
        this.positive_vote = positive_vote;
    }

    public int getNegative_vote() {
        return negative_vote;
    }

    public void setNegative_vote(int negative_vote) {
        this.negative_vote = negative_vote;
    }

    public String getLien_video() {
        return lien_video;
    }

    public void setLien_video(String lien_video) {
        this.lien_video = lien_video;
    }

    public int getFk_id_utilisateur() {
        return fk_id_utilisateur;
    }

    public void setFk_id_utilisateur(int fk_id_utilisateur) {
        this.fk_id_utilisateur = fk_id_utilisateur;
    }

    public Date getDate_video() {
        return date_video;
    }

    public void setDate_video(Date date_video) {
        this.date_video = date_video;
    }
    
    
    
    public String getTitre_video() {
        return titre_video;
    }

    public void setTitre_video(String titre_video) {
        this.titre_video = titre_video;
    }

    public String getDescription_video() {
        return description_video;
    }

    public void setDescription_video(String description_video) {
        this.description_video = description_video;
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

    @Override
    public String toString() {
        return "Video{" + "pk_id_video=" + pk_id_video + ", positive_vote=" + positive_vote + ", negative_vote=" + negative_vote + ", titre_video=" + titre_video + ", description_video=" + description_video + ", lien_video=" + lien_video + ", score=" + score + ", fk_id_utilisateur=" + fk_id_utilisateur + ", date_video=" + date_video + '}';
    }
    
    
}
