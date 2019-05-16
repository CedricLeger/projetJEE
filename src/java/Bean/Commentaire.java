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
public class Commentaire {
    private int pk_id_comment;
    private String text_comment;
    private boolean report=false;
    private int fk_id_video;

    public Commentaire() {
    }

    public Commentaire(int pk_id_comment, String text_comment, int fk_id_video) {
        this.pk_id_comment = pk_id_comment;
        this.text_comment = text_comment;
        this.fk_id_video = fk_id_video;
    }
    
    public Commentaire(int pk_id_comment, String text_comment, boolean report, int fk_id_video) {
        this.pk_id_comment = pk_id_comment;
        this.text_comment = text_comment;
        this.report = report;
        this.fk_id_video = fk_id_video;
    }

    public Commentaire(int i, String pas_de_commentaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    public int getId_comment() {
        return pk_id_comment;
    }

    public void setId_comment(int pk_id_comment) {
        this.pk_id_comment = pk_id_comment;
    }

    public String getText_comment() {
        return text_comment;
    }

    public void setText_comment(String text_comment) {
        this.text_comment = text_comment;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public int getId_video() {
        return fk_id_video;
    }

    public void setId_video(int fk_id_video) {
        this.fk_id_video = fk_id_video;
    }
    
    
    
}
