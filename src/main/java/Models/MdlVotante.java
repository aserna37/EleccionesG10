/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Classes.ClsVotante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class MdlVotante extends Conexion{
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    
    
    public DefaultTableModel MostrarVotantes() {

        DefaultTableModel tbvotantes = new DefaultTableModel();

        tbvotantes.addColumn("Documento");
        tbvotantes.addColumn("Nombres");
        tbvotantes.addColumn("Apellidos");
        

        String[] dato = new String[3];

        String sql = "SELECT personas.perDocumento as documento, personas.perNombres as nombres,personas.perApellidos as apellidos FROM votantes INNER JOIN personas ON votantes.votDocumento = personas.perDocumento";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2).toUpperCase();
                dato[2] = rs.getString(3).toUpperCase();
                tbvotantes.addRow(dato);
            }
            return tbvotantes;

        } catch (SQLException e) {

            System.err.println(e);
            return tbvotantes;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public boolean RegistrarPersonaVotante(ClsVotante vot) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO personas (perDocumento,perNombres,perApellidos,perFNacimiento,perCelular,perEmail) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vot.getDocumento());
            ps.setString(2, vot.getNombres());
            ps.setString(3, vot.getApellidos());
            ps.setString(4, vot.getFecha_nac());
            ps.setString(5, vot.getCelular());
            ps.setString(6, vot.getEmail());
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

    public boolean RegistrarVotante(ClsVotante vot) {

        PreparedStatement ps1 = null;
        Connection con = getConexion();

        String sql = "INSERT INTO votantes (votDocumento,votEstado) VALUES (?,?)";

        try {
            ps1 = con.prepareStatement(sql);
            ps1.setString(1, vot.getDocumento());
            ps1.setString(2, vot.getEstado());
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
    
    public boolean buscarVotante(ClsVotante vot) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * FROM votantes INNER JOIN personas ON votantes.votDocumento = personas.perDocumento where votantes.votDocumento=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vot.getDocumento());
            rs = ps.executeQuery();
            if (rs.next()) {
                vot.setDocumento(rs.getString("perDocumento"));
                vot.setNombres(rs.getString("perNombres"));
                vot.setApellidos(rs.getString("perApellidos"));
                vot.setFecha_nac(rs.getString("perFNacimiento"));
                vot.setCelular(rs.getString("perCelular"));
                vot.setEmail(rs.getString("perEmail"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    
    public boolean ActualizarPersonaVotante(ClsVotante vot) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "update personas set perNombres=?, perApellidos=?, perFNacimiento=?, perCelular=?, perEmail = ? where perDocumento=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vot.getNombres());
            ps.setString(2, vot.getApellidos());
            ps.setString(3, vot.getFecha_nac());
            ps.setString(4, vot.getCelular());
            ps.setString(5, vot.getEmail());
            ps.setString(6, vot.getDocumento());
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
    
}
