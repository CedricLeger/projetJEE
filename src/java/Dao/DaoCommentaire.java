/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Commentaire;
import Bean.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandra
 */

public class DaoCommentaire implements Dao<Commentaire> {
    
    //définition de table commentaire de la bdd
    private final String table = "commentaire";

    //fonction de recherche par l'id du commentaire
    @Override
    public Commentaire find(Integer id) {
        Commentaire retObj = null;
        String sql = "SELECT * FROM "
                + table
                + " WHERE pk_id_comment= ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                retObj = new Commentaire(id, result.getString("text_comment"), result.getInt("fk_id_video"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }
    
    //fonction de création des commentaire dans la bdd
    @Override
    public Commentaire create(Commentaire obj) {
        Commentaire retObj = null;
        // requete SQL : Attention aux espaces !
        String sql = "INSERT INTO "
                + table
                + " (pk_id_comment,text_comment,report,fk_id_video) "
                + " VALUES (?,?,?,?) ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, obj.getId_comment());
            pstmt.setString(2, obj.getText_comment());
            pstmt.setBoolean(3, obj.isReport());
            pstmt.setInt(4, obj.getId_video());
            //il va generer la clef automatiquement pour qu'on puisse plus tard identifier le nv object
            pstmt.executeUpdate();
            ResultSet generateKeys = pstmt.getGeneratedKeys();
            if (generateKeys.first()) {
            retObj = this.find(generateKeys.getInt(1));
            }
        } catch (SQLException ex) {

            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;

    }

    //fonction de suppression d'un commentaire
    @Override
    public void delete(Commentaire obj) {
        String sql = "DELETE FROM " + table + " WHERE pk_id_comment=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_comment());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //fonction de modification d'un attribut d'un commentaire
    @Override
    public Commentaire update(Commentaire obj) {
        String sql = "UPDATE "
                + table
                + "SET report=1"
                + " WHERE report=0";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,obj.getId_comment());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    //fonction qui renvoie la liste total des commentaires
    @Override
    public List<Commentaire> findAll() {
        ArrayList<Commentaire> retObj = new ArrayList<>();
        String sql = "SELECT * FROM "
                + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"), result.getString("text_comment"),
                        result.getInt("fk_id_video")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }
    //fonction qui revoie la liste totale des commentaire ayant un report dessus
    public List<Commentaire> findByReport() {
        ArrayList<Commentaire> retObj = new ArrayList<>();
        String sql = "SELECT * FROM "
                + table
                + " WHERE report=true ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"), result.getString("text_comment"),
                        result.getInt("fk_id_video")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }
    //fonction qui permet d'avoir la liste des commentaires grâce a l'id
    public List<Commentaire> findById(Commentaire comment) {
        ArrayList<Commentaire> retObj = new ArrayList<>();
        String sql = "SELECT * FROM "
                + table
                + " WHERE fk_id_video=? ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"), result.getString("text_comment"),
                        result.getInt("fk_id_video")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }
      //permet de modifier tous les commentaires si l'utilisateur est supprimé
      public void updateAllComment(Utilisateur user) {
   
        
        String sql = "UPDATE "
                + table
                + "SET text_comment=Voici ce qui arrive aux lourds"
                + " WHERE pk_id_utilisateur=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,user.getId_utilisateur());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
//      public void createReport(Commentaire obj) {
//        String sql= "UPDATE " 
//                +table 
//                +"SET report=1" 
//                + " WHERE report=0";
//        try {
//            PreparedStatement pstmt= connection.prepareStatement(sql);
//            pstmt.setBoolean(1, true);
//            int nb_ligne = pstmt.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
//        }
}

//trouver en base de donnée s"il y a déja un report de fait ou non
//    public String findReport(){
//        String retObj="";
//        String sql = "SELECT * FROM "
//               + table
//               + " WHERE report=?";
//                
//           try {
//              PreparedStatement pstmt = connection.prepareStatement(sql);
//              ResultSet result = pstmt.executeQuery();
//              if (result.next())
//            {
//             
//            }
//           } catch (SQLException ex) {
//               Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
//    }
//           return retObj;
//        
//}
//    //permet d'ajouter un report si la fonction findReport renvoi 0
//    public String doReport(){
//        String retObj="";
//    }
