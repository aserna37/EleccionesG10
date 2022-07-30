
package Models;

import Classes.ClsPartido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MdlPartido extends Conexion {
    
    public ArrayList<ClsPartido> getPartidos(){
        
        ArrayList<ClsPartido> listaPartidos = new ArrayList<>();
        Connection con = getConexion();
        Statement stmt;
        ResultSet rs;
        
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM partidos_politicos ORDER BY parId");
            
            while (rs.next()) {      
                
                ClsPartido partido = new ClsPartido();
                partido.setId(rs.getInt("parId"));
                partido.setNombre(rs.getString("parNombre"));
                listaPartidos.add(partido);
                
            }
        } catch (SQLException ex) {
            
        }
        return listaPartidos;
        
        
        
        
    }
    
}
