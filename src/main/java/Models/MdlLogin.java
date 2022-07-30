
package Models;

import Classes.ClsLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MdlLogin extends Conexion {
    
    public boolean validarLogin(ClsLogin clslogin){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "select * from votantes where votDocumento=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clslogin.getUsername());
            rs = ps.executeQuery();
            
            if(rs.next()){
                clslogin.setUsername(rs.getString("votDocumento"));
                clslogin.setEstado(rs.getString("votEstado"));
                return true;
            }
            return false;
        } catch (Exception e) {
            
            System.err.println(e);
            return false;
        }
        
    }
    
}
