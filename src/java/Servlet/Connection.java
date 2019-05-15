/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Utilisateur;
import Forms.ConnectionForms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Leger Cédric
 */
public class Connection extends HttpServlet {

    private static final String ATT_USER = "utilisateur";
    private static final String ATT_FORM = "form";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    private static final String VUE = "/WEB-INF/view/connection.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request,
                response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            /* Préparation de l'objet formulaire */
            ConnectionForms form = new ConnectionForms();
            
            /* Traitement de la requête et récupération du bean en résultant */
            Utilisateur user = form.connectUtilisateur(request);
            /* Récupération de la session depuis la requête */
            HttpSession session = request.getSession();
            /**
             * Si aucune erreur de validation n'a eu lieu, alors ajout du bean user
             * à la session, sinon suppression du bean de la session.
             */
            if (form.getErrors().isEmpty()) {
                session.setAttribute(ATT_SESSION_USER, user);
            } else {
                session.setAttribute(ATT_SESSION_USER, null);
            }
            /* Stockage du formulaire et du bean dans l'objet request */
            request.setAttribute(ATT_FORM, form);
            request.setAttribute(ATT_USER, user);
            this.getServletContext()
                    .getRequestDispatcher(VUE)
                    .forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
