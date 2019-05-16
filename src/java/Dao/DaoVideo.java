/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Video;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandra
 */
public class DaoVideo implements Dao<Video>{
       
    private final String table= "videos";
    
    @Override
    public Video find(Integer id) {
    Video retObj=null;
       String sql = "SELECT * FROM "
               + table
               + " WHERE pk_id_video= ?";
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first())
            {
                retObj = new Video(id,result.getInt("positive_vote"),result.getInt("negative_vote"),
                        result.getString("titre_video"),result.getString("description_video"),result.getString("lien_video"),
                        result.getDouble("score"),result.getInt("pk_id_video"),result.getDate("date_video"));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }    

    @Override
    public Video create(Video obj) {
        System.out.println(obj);
        Video retObj=null;
        // requete SQL : Attention aux espaces !
        String sql = "INSERT INTO "
               + table
               + " (lien_video,positive_vote,negative_vote,titre_video,description_video,score,	fk_id_utilisateur) "
               + " VALUES (?,?,?,?,?,?,?) ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,obj.getLien_video());
            pstmt.setInt(2,obj.getPositive());
            pstmt.setInt(3,obj.getNegative());
            pstmt.setString(4,obj.getTitre_video());
            pstmt.setString(5,obj.getDescription_video());
            pstmt.setDouble(6,obj.getScore());
            pstmt.setInt(7,obj.getFk_id_utilisateur());
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
            
            Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    
    }
    
    /**
     * Utiliser quand un admin supprime un compte
     * @param obj 
     */

    @Override
    public void delete(Video obj) {
        String sql= "DELETE FROM " + table + " WHERE pk_id_video=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, obj.getId_video());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
    public Video update(Video obj) {
        Video retObj = null;
        String sql= " UPDATE " + table + " SET lien_video=?, " 
                +" titre_video=? "
                +" WHERE pk_id_video=? ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
      
            pstmt.setString(1,obj.getLien_video());
            pstmt.setString(2,obj.getTitre_video());
            pstmt.setInt(3,obj.getId_video());
            
      pstmt.executeUpdate();
      
      retObj=find(obj.getId_video());
      
      
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    @Override
    public List<Video> findAll() {
        ArrayList<Video> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table;
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next())
            {
                retObj.add(new Video(result.getInt("pk_id_video") ,result.getInt("positive_vote"),result.getInt("negative_vote"),
                        result.getString("titre_video"),result.getString("description_video"),result.getString("lien_video"),
                        result.getDouble("score"),result.getInt("pk_id_video"),result.getDate("date_video")));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }
    
    public void AddDate(Video obj) {
       Video retObj = null;
       String sql = "INSERT INTO "
               + table
               + " (date_video) "
               + " VALUES (GETDATE()) "
               + " WHERE pk_id_video=? ";
               
              try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setDate(1, (Date) obj.getDate_video());
              ResultSet result = pstmt.executeQuery();
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
            
            Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
    }

    public List<Video> findByDate() {
      ArrayList<Video> retObj= new ArrayList<>(); 
      int nb= 30;
       String sql = "SELECT * FROM "
               + table
               + " WHERE dayofyear(date_video) <= dayofyear(NOW()) - 30 ";
               
              try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next() && retObj.size() <= 10)
            {
                retObj.add(new Video(result.getInt("pk_id_video") ,result.getInt("positive_vote"),result.getInt("negative_vote"),
                        result.getString("titre_video"),result.getString("description_video"),result.getString("lien_video"),
                        result.getDouble("score"),result.getInt("pk_id_video"),result.getDate("date_video")));
                
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoVideo.class.getName()).log(Level.SEVERE, null, ex);
            }
           return retObj;
           
    }
    
}
