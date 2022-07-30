/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/elecciones";
    private static final String USER = "root";
    private static final String CLAVE = "";
        
    public Connection getConexion(){
        System.out.println("Conectando a base de datos...");
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Conectado a la base de datos!!");
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
}
