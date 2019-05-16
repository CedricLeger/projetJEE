/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Utilisateur;
import Bean.Video;
import Dao.DaoUtilisateur;
import Forms.VideoForms;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sayoy
 */
public class AdminUtilisateur extends HttpServlet {
  //* Des constantes */
    private static final String BTN= "btn";
    private static final String EMAIL_FIELD = "email";
    private static final String ID_UTILISATEUR = "id_utilisateur";
    private static final String NAME_FIELD = "pseudo";
    
    public static final String VIEW= "/WEB-INF/view/AdminUtilisateur.jsp";
    
    DaoUtilisateur daoutilisateur = new DaoUtilisateur();

    //Les collections
    private final ArrayList<Utilisateur> retObjUtilisateur = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        findUtil();
        request.setAttribute("retObjUtilisateur", retObjUtilisateur);
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(request, response);
    }

    private void findUtil()
     {
         retObjUtilisateur.removeAll(retObjUtilisateur);
         retObjUtilisateur.addAll(daoutilisateur.findAll());
         
     }
 
/** Méthode utilitaire qui retourne null si un champ est vide, et son
*contenu
* sinon. */
    
    private static String getParamValue(HttpServletRequest request, String paramKey) {
        String value = request.getParameter(paramKey);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value.trim();
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String btn = getParamValue(request, BTN);
        System.out.println(btn);
        String id_util1= getParamValue(request, ID_UTILISATEUR);
        String email = getParamValue(request, EMAIL_FIELD);
        String name = getParamValue(request, NAME_FIELD);
        int id_util = Integer.parseInt(id_util1);
        /* Préparation de l'objet formulaire */
        Utilisateur util = new Utilisateur();
        util.setId_utilisateur(id_util);
        util.setStatut(btn);
        util.setMail(email);
        util.setPseudo(name);
        daoutilisateur.update(util);
        

        response.sendRedirect(this.getServletContext().getContextPath() +"/AdminUtilisateur");
    }
    
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
