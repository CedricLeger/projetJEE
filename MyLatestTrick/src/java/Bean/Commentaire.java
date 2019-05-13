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
    private int id_comment;
    private String text_comment;
    private boolean report=false;
    private int id_video;

    public Commentaire() {
    }

    public Commentaire(int id_comment, String text_comment, int id_video) {
        this.id_comment = id_comment;
        this.text_comment = text_comment;
        this.id_video = id_video;
    }
    
    public Commentaire(int id_comment, String text_comment, boolean report, int id_video) {
        this.id_comment = id_comment;
        this.text_comment = text_comment;
        this.report = report;
        this.id_video = id_video;
    }

    
    
    
    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
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
        return id_video;
    }

    public void setId_video(int id_video) {
        this.id_video = id_video;
    }
    
    
    
}
