
package Models;

import Classes.ClsEleccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class MdlEleccion extends Conexion{
    
       
    public ArrayList<ClsEleccion> MostrarListaCandidatos() {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    ArrayList<ClsEleccion> listaEleccion = new ArrayList<>();
    
        try {
            String sql = "SELECT personas.perDocumento as documento, personas.perNombres as nombres,personas.perApellidos as apellidos, candidatos.canPartido as partido FROM candidatos INNER JOIN personas ON candidatos.canDocumento = personas.perDocumento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {

                    ClsEleccion clseleccion = new ClsEleccion();
                    clseleccion.setDocumentoCandidato(rs.getString("documento"));
                    clseleccion.setNombres(rs.getString("nombres").toUpperCase());
                    clseleccion.setApellidos(rs.getString("apellidos").toUpperCase());
                    listaEleccion.add(clseleccion); 
            }
            
        } catch (Exception e) {
        } 
        return listaEleccion;
    
    
    }
    
    
    
    public boolean RegistrarEleccion(ClsEleccion ele) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO votaciones (eleDocumentoCan,eleDocumentoVot,eleFechaInicio,eleFechaFinal) VALUES (?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ele.getDocumentoCandidato());
            ps.setString(2, ele.getDocumentoVotante());
            ps.setString(3, ele.getFechaInicio());
            ps.setString(4, ele.getFechaFinal());
            ps.execute();

            return true;

        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    public boolean ActualizarEstadoVotante(ClsEleccion ele) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "update votantes set votEstado=? where votDocumento=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, ele.getDocumentoVotante());
            ps.execute();

            return true;

        } catch (SQLException e) {

            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    
    }
    
    
    public DefaultTableModel MostrarResultados() {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        DefaultTableModel tbresultados = new DefaultTableModel();

        tbresultados.addColumn("Nombres");
        tbresultados.addColumn("Apellido");
        tbresultados.addColumn("Partido");
        tbresultados.addColumn("No. votos");
        

        String[] dato = new String[4];

        String sql = "SELECT personas.perNombres as nombres, personas.perApellidos as apellidos, candidatos.canPartido as partido, COUNT(*) as votos FROM votaciones INNER JOIN candidatos INNER JOIN personas WHERE votaciones.eleDocumentoCan = candidatos.canDocumento AND votaciones.eleDocumentoCan = personas.perDocumento GROUP BY 2";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                dato[0] = rs.getString(1).toUpperCase();
                dato[1] = rs.getString(2).toUpperCase();
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                tbresultados.addRow(dato);
            }
            return tbresultados;

        } catch (SQLException e) {

            System.err.println(e);
            return tbresultados;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
