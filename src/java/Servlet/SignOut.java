/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Utilisateur;
import Dao.DaoUtilisateur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dizer
 */
public class SignOut extends HttpServlet { 
    
        private static final String URL_REDIRECTION = "/WEB-INF/view/index.jsp";

        @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //création d'un objet de type session 
            HttpSession session = request.getSession();
            //utilisation du get attribute pour trouver l'utilisateur connecté actuel
            Utilisateur user = (Utilisateur)session.getAttribute("sessionUtilisateur");
            //debug pour afficher l'utilisateur a supprimer
            System.out.println(user);
            //instanciation d'un daoUtilisateur pour effacher l'utilisateur en base de donnée avec les données récupérer dans la session
            DaoUtilisateur dauser= new DaoUtilisateur();
            dauser.delete(user);
            //retour à la vue principal index( accueil)
            response.sendRedirect(getServletContext()
                .getContextPath() + URL_REDIRECTION);
    }
}

