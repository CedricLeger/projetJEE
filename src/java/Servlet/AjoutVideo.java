/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Video;
import Forms.VideoForms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leger Cédric
 */
public class AjoutVideo extends HttpServlet {
  //* Des constantes */
    private static final String ATT_FORM = "form";
    private static final String ATT_VIDEO = "video";
    public static final String VIEW = "/WEB-INF/view/AjoutVideo.jsp";

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(request, response);
    }

 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        VideoForms form = new VideoForms();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        Video video = form.creationVideo(request);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_VIDEO, video);

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
