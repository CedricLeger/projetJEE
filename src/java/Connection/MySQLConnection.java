/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author Sandra
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sandra
 */
public final class MySQLConnection {
    private static Connection connection=null;
    
    private MySQLConnection()
    {
        
    }
    
    public static Connection getInstance()
    {
        if (connection==null)
        {
            Properties config= new Properties();
            try(InputStream in= MySQLConnection.class.getResourceAsStream("../ressource/config_1.properties"))
            {
                config.load(in); 
               
            } catch (IOException ex) 
                {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
                }
            String url= "jdbc:"+ config.getProperty("sgbdr") //tout cela est dans le fichier config.properties
                    + "://" + config.getProperty("host")
                    + ":" + config.getProperty("port")
                    +"/" + config.getProperty("database");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url,config); 
            } catch (SQLException ex) 
                {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(2);
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
