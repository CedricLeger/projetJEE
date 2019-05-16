/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Commentaire;
import Forms.CommentForms;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leger Cédric
 */
public class AjoutComment extends HttpServlet {
  //* Des constantes */
    private static final String ATT_FORM = "form";
    private static final String ATT_COMMENT = "comment";
    public static final String VIEW = "/WEB-INF/view/VueComplete.jsp";
    public static final String VIEWADMIN = "/WEB-INF/view/Admin.jsp";


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
        CommentForms form = new CommentForms();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        HttpSession session=request.getSession();;
        Commentaire comment = form.creationComment(request,session);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_COMMENT, comment);

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
       CommentForms form = new CommentForms();
        
        HttpSession session=req.getSession();
        form.suppressionCommentaire(req, session);
        
        this.getServletContext()
                .getRequestDispatcher(VIEWADMIN)
                .forward(req, resp);
         
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
