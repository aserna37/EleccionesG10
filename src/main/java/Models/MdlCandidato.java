package Models;

import Classes.ClsCandidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MdlCandidato extends Conexion {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();

    public DefaultTableModel MostrarCandidatos() {

        DefaultTableModel tbcandidatos = new DefaultTableModel();

        tbcandidatos.addColumn("Documento");
        tbcandidatos.addColumn("Nombres");
        tbcandidatos.addColumn("Apellidos");
        tbcandidatos.addColumn("Partido Politico");

        String[] dato = new String[4];

        String sql = "SELECT personas.perDocumento as documento, personas.perNombres as nombres,personas.perApellidos as apellidos, candidatos.canPartido as partido FROM candidatos INNER JOIN personas ON candidatos.canDocumento = personas.perDocumento";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                tbcandidatos.addRow(dato);
            }
            return tbcandidatos;

        } catch (SQLException e) {

            System.err.println(e);
            return tbcandidatos;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean RegistrarPersonaCandidato(ClsCandidato can) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO personas (perDocumento,perNombres,perApellidos,perFNacimiento,perCelular,perEmail) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, can.getDocumento());
            ps.setString(2, can.getNombres());
            ps.setString(3, can.getApellidos());
            ps.setString(4, can.getFecha_nac());
            ps.setString(5, can.getCelular());
            ps.setString(6, can.getEmail());
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

    public boolean RegistrarCandidato(ClsCandidato can) {

        PreparedStatement ps1 = null;
        Connection con = getConexion();

        String sql = "INSERT INTO candidatos (canDocumento,canPartido,canCiudad,canDescripcion,canMensaje) VALUES (?,?,?,?,?)";

        try {
            ps1 = con.prepareStatement(sql);
            ps1.setString(1, can.getDocumento());
            ps1.setString(2, can.getPartidoPolitico());
            ps1.setString(3, can.getCiudadOrigen());
            ps1.setString(4, can.getDescripcion());
            ps1.setString(5, can.getMensajeCampana());
            ps1.execute();
            return true;
        } catch (Exception e) {
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

    public boolean buscarCandidato(ClsCandidato can) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * FROM candidatos INNER JOIN personas ON candidatos.canDocumento = personas.perDocumento where candidatos.canDocumento=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, can.getDocumento());
            rs = ps.executeQuery();
            if (rs.next()) {
                can.setDocumento(rs.getString("perDocumento"));
                can.setNombres(rs.getString("perNombres"));
                can.setApellidos(rs.getString("perApellidos"));
                can.setFecha_nac(rs.getString("perFNacimiento"));
                can.setCelular(rs.getString("perCelular"));
                can.setEmail(rs.getString("perEmail"));
                can.setPartidoPolitico(rs.getString("canPartido"));
                can.setCiudadOrigen(rs.getString("canCiudad"));
                can.setDescripcion(rs.getString("canDescripcion"));
                can.setMensajeCampana(rs.getString("canMensaje"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    
    public boolean ActualizarPersonaCandidato(ClsCandidato can) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "update personas set perNombres=?, perApellidos=?, perFNacimiento=?, perCelular=?, perEmail = ? where perDocumento=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, can.getNombres());
            ps.setString(2, can.getApellidos());
            ps.setString(3, can.getFecha_nac());
            ps.setString(4, can.getCelular());
            ps.setString(5, can.getEmail());
            ps.setString(6, can.getDocumento());
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
    
    
    public boolean ActualizarCandidato(ClsCandidato can) {

        PreparedStatement ps1 = null;
        Connection con = getConexion();

        String sql = "update candidatos set canPartido=?, canCiudad=?, canDescripcion=?, canMensaje=? where canDocumento=?";

        try {
            ps1 = con.prepareStatement(sql);
            ps1.setString(1, can.getPartidoPolitico());
            ps1.setString(2, can.getCiudadOrigen());
            ps1.setString(3, can.getDescripcion());
            ps1.setString(4, can.getMensajeCampana());
            ps1.setString(5, can.getDocumento());
            ps1.execute();
            return true;
        } catch (Exception e) {
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


}
