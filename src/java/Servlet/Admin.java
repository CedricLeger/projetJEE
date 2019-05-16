/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Commentaire;
import Bean.Video;
import Dao.DaoCommentaire;
import Dao.DaoVideo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sandra
 */
public class Admin extends HttpServlet {

    
    private static final String VIEW = "/WEB-INF/view/Admin.jsp"; 
    //Constante pour video
    private static final String BTN = "btn";
    private static final String LIEN = "lien"; 
    private static final String TITRE = "titre"; 
    private static final String ID_VIDEO = "id_video"; 
   
    //Constante pour commentaire
    private static final String TEXT_COMMENT = "text_comment";

    private static final String ID_COMMENT = "id_comment"; 
    
    //On instancie les dao
    DaoVideo daovideo = new DaoVideo();
    DaoCommentaire daocomment = new DaoCommentaire();
    
    //Les collections
    private final ArrayList<Video> retObj = new ArrayList<>();
    private final ArrayList<Commentaire> reportComment = new ArrayList<>();
    private final ArrayList<Commentaire> retObjComment = new ArrayList<>();
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        findVideo();
        findComment();
        request.setAttribute("retobj", retObj);
        if(reportComment.isEmpty())
        {
            reportComment.add(new Commentaire(0,"Pas de commentaire"));
        }
        else
        {
        request.setAttribute("reportComment", reportComment);
        }
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(request, response);
    }
    
    /**
      * recupere toutes les videos 
      */
     private void findVideo()
     {
         retObj.removeAll(retObj);
         retObj.addAll(daovideo.findAll());
         
     }
     
     private void findComment()
     {
         reportComment.removeAll(reportComment);
         reportComment.addAll(daocomment.findByReport());
         
     }

     private static String getParamValue(HttpServletRequest request, String paramKey) {
        String value = request.getParameter(paramKey);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value.trim();
        }
    }
     
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        String btn = getParamValue(req, BTN);
        switch(btn)
        {
            case "Supprimer" :
            {
                
             
             HttpSession session=req.getSession();
             suppressionVideo(req, session);
             break;   
            }
            case "Desactiver":
            {
             HttpSession session=req.getSession();
             desactiveVideo(req, session);
             break;
            }
            case "Conserver" : 
            {
             HttpSession session=req.getSession();
             adminReport(req, session);
             break;
            }
            case "Suppr" : 
            {
             HttpSession session=req.getSession();
             suppressionComment(req, session);
             break;
            }
        }
        
        
        //this.doGet(req, resp);
        resp.sendRedirect(this.getServletContext().getContextPath() +"/Admin");
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Change le lien de la video 
     * @param request
     * @param session 
     */
    public void desactiveVideo(HttpServletRequest request, HttpSession session)
    {
        /* Récupération des champs du formulaire */
        String lien = getParamValue(request,LIEN );
        String id_video1= getParamValue(request, ID_VIDEO);
        int id_video = Integer.parseInt(id_video1);
        System.out.println(lien);
        String titre= getParamValue(request, TITRE);
        //String description= getParamValue(request, DESCRIPTION);*/
        
        Video video = new Video();
        video.setId_video(id_video);
        video.setTitre_video(titre);
        video.setLien_video("video desactiver");
        daovideo.update(video);
    }
    
    /**
     * Supprime une video
     * @param request
     * @param session 
     */
    
    public void suppressionVideo(HttpServletRequest request, HttpSession session) 
     {
        String id_video1= getParamValue(request, ID_VIDEO);
        int id_video = Integer.parseInt(id_video1);
        
        Video video = new Video();
        video.setId_video(id_video);
        
        retObjComment.addAll(daocomment.findById(video.getPk_id_video()));
         deleteVideo(video,retObjComment);
     }
    
    public void suppressionComment(HttpServletRequest request, HttpSession session) 
     {
        String id_comment1= getParamValue(request, ID_COMMENT);
        int id_comment = Integer.parseInt(id_comment1);
        
        Commentaire comment = new Commentaire();
        comment.setId_comment(id_comment);
        deleteComment(comment);
     }
     
     
       /**
      * Supprime une video et ses commentaires
      * @param video et arraylist des commentaires 
      */
     
     private void deleteVideo(Video video, ArrayList<Commentaire> comment)
     {
         daovideo.delete(video);
         //on parcours la collection pour supprimer les élèments 
         /*for (Commentaire o : comment)
         {
         daocomment.delete(o);
         }*/
     }
     
     
     private void deleteComment(Commentaire comment)
     {
         daocomment.delete(comment);
         //on parcours la collection pour supprimer les élèments 
         /*for (Commentaire o : comment)
         {
         daocomment.delete(o);
         }*/
     }
     
     /**
      * Met a false le report
      * @param request
      * @param session 
      */
     public void adminReport(HttpServletRequest request, HttpSession session) 
     {
     String text_comment = getParamValue(request,TEXT_COMMENT );
     String id_video1= getParamValue(request, ID_COMMENT);
         System.out.println(id_video1);
     int id_comment= Integer.parseInt(id_video1);
        
        Commentaire comment = new Commentaire();
        comment.setId_comment(id_comment);
        comment.setText_comment(text_comment);
        comment.setReport(false);
        daocomment.update(comment);
        
    }
}
