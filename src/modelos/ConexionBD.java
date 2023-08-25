/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author Manuela Gomez
 */
public class ConexionBD {
    
     private final String base = "tallerProductos";
     private final String user = "root";
     private final String password = "";
     private final String url = "jdbc:mariadb://localhost:3306/" + base;
     private Connection con = null;
     
    public Connection getConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(this.url,this.user,this.password);
        }catch(SQLException e){
            System.err.println(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
        
    }
    
}
