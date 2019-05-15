/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Utilisateur;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class DaoUtilisateur implements Dao<Utilisateur>{
       
    private final String table= "utilisateur";
    
    @Override
    public Utilisateur find(Integer id) {
    Utilisateur retObj=null;
       String sql = "SELECT * FROM "
               + table
               + " WHERE pk_id_utilisateur= ?";
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first())
            {
                retObj = new Utilisateur(id , result.getString("mail"), result.getString("password"),result.getString("pseudo") );
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }    

    @Override
    public Utilisateur create(Utilisateur obj) {
        Utilisateur retObj=null;
        Utilisateur test=null;
        // requete SQL : Attention aux espaces !
        String sql = "INSERT INTO "
               + table
               + " (mail,password,pseudo,statut) "
               + " VALUES (?,?,?,?) ";
        
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,obj.getMail());
            pstmt.setString(2,encryptThisString(obj.getPassword()));
            pstmt.setString(3,obj.getPseudo());
            pstmt.setString(4, obj.getStatut());
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
            
            Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    
    }
    
    /**
     * Utiliser quand un admin supprime un compte
     * @param obj 
     */

    @Override
    public void delete(Utilisateur obj) {
        String sql= "DELETE FROM " + table + " WHERE mail=?";
        try {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setString(1, obj.getMail());
            int nb_ligne = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
    public Utilisateur update(Utilisateur obj) {
        throw new RuntimeException("methode non implementer");
    }

    @Override
    public List<Utilisateur> findAll() {
        ArrayList<Utilisateur> retObj= new ArrayList<>(); 
       String sql = "SELECT * FROM "
               + table;
        try
        {
            PreparedStatement pstmt= connection.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next())
            {
                retObj.add(new Utilisateur(result.getInt("id"),result.getString("mail"),
                       result.getString("password"), result.getString("pseudo"), result.getBoolean("admin"), result.getString("statut") ));
            }
        } catch (SQLException ex)
            {
               Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        return retObj;
    }

    public Utilisateur findByEmail(String mail) {
      Utilisateur retObj= null; 
       String sql = "SELECT * FROM "
               + table
               + " WHERE mail = ? ";
                
           try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setString(1, mail);
              ResultSet result = pstmt.executeQuery();
              if (result.first())
            {
                retObj=new Utilisateur(result.getInt("id"),mail,result.getString("password"),
                        result.getString("pseudo"));
            }
           } catch (SQLException ex) {
               Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
           }
           return retObj;
    }
    
    public Boolean findlog(String mail, String password) {
      Boolean retObj= false; 
       String sql = "SELECT * FROM "
               + table
               + " WHERE mail = ?";
                
           try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setString(1,mail);
              ResultSet result = pstmt.executeQuery();
              if(result.first())
              {
                 retObj = ((mail.equals(result.getString("mail"))) &&(encryptThisString(password).equalsIgnoreCase(result.getString("password"))));
              }
                }   catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
           return retObj;
    }
           

//              if (result.first())
//            {
//                return true;
//            }
//           } catch (SQLException ex) {
//               Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
//           }
//           return false;
  
    public Boolean findMail(String mail) {
      Boolean retObj= false; 
       String sql = "SELECT * FROM "
               + table
               + " WHERE mail = ? ";
               
               try {
              PreparedStatement pstmt = connection.prepareStatement(sql);
              pstmt.setString(1, mail);
              ResultSet result = pstmt.executeQuery();
              retObj = result.first();
              
           } catch (SQLException ex) {
               Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
           }
           return retObj;
           
    }
    public static String encryptThisString(String input) 
    { 
        try { 
// getInstance() method is called with algorithm SHA-1 
MessageDigest md = MessageDigest.getInstance("SHA-1"); 
// digest() method is called // to calculate message digest of the input string // returned as array of byte 
byte[]messageDigest = md.digest(input.getBytes()); 
// Convert byte array into signum representation 
BigInteger no = new BigInteger(1, messageDigest); 
// Convert message digest into hex value 
String hashtext = no.toString(16); // Add preceding 0s to make it 32 bit 
while (hashtext.length() < 32) { hashtext = "0" + hashtext; } 
// return the HashText 
return hashtext; 
        } 
// For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { throw new RuntimeException(e); } }
}
