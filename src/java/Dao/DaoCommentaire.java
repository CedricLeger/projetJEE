/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Commentaire;
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
public class DaoCommentaire implements Dao<Commentaire>{
       
    private final String table= "commentaire";
    
    @Override
    public Commentaire find(Integer id) {
    Commentaire retObj=null;
       String sql = "SELECT * FROM "
               + table
               + " WHERE pk_id_comment= ?";
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first())
            {
                retObj = new Commentaire(id , result.getString("text_comment"),result.getInt("fk_id_video") );
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }    

    @Override
    public Commentaire create(Commentaire obj) {
        Commentaire retObj=null;
        // requete SQL : Attention aux espaces !
        String sql = "INSERT INTO "
               + table
               + " (pk_id_comment,text_comment,report,fk_id_video) "
               + " VALUES (?,?,?,?) ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,obj.getId_comment());
            pstmt.setString(2,obj.getText_comment());
            pstmt.setBoolean(3,obj.isReport());
            pstmt.setInt(4,obj.getId_video());
            //il va generer la clef automatiquement pour qu'on puisse plus tard identifier le nv object
            pstmt.executeUpdate(); 
            ResultSet generateKeys = pstmt.getGeneratedKeys();
            if (generateKeys.first())
            {
                //Deux methodes : 
                //1 : obj.setId_personne(generateKeys.getInt(1));
                //1 c'est la colonne dans laquelle il doit aller chercher l'info
                retObj= this.find(generateKeys.getInt(1));
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    
    }
    
    /**
     * Utiliser quand un admin supprime un compte
     * @param obj 
     */

    @Override
    public void delete(Commentaire obj) {
        String sql= "DELETE FROM " + table + " WHERE pk_id_comment=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_comment());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
    public Commentaire update(Commentaire obj) {
        throw new RuntimeException("methode non implementer");
    }

    @Override
    public List<Commentaire> findAll() {
        ArrayList<Commentaire> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table;
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next())
            {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"),result.getString("text_comment"),
                       result.getInt("fk_id_video") ));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }

    
    public List<Commentaire> findByReport() {
       ArrayList<Commentaire> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table
               + " WHERE report=true ";
                
           try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              ResultSet result = pstmt.executeQuery();
              if (result.next())
            {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"),result.getString("text_comment"),
                        result.getInt("fk_id_video")));
            }
           } catch (SQLException ex) {
               Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
           }
           return retObj;
    }
    
    public List<Commentaire> findById(Commentaire comment) {
       ArrayList<Commentaire> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table
               + " WHERE fk_id_video=? ";
                
           try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              ResultSet result = pstmt.executeQuery();
              if (result.next())
            {
                retObj.add(new Commentaire(result.getInt("pk_id_comment"),result.getString("text_comment"),
                        result.getInt("fk_id_video")));
            }
           } catch (SQLException ex) {
               Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
           }
           return retObj;
    }
    
}
