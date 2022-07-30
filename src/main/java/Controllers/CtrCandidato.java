package Controllers;

import Classes.ClsCandidato;
import Classes.ClsPartido;
import Models.MdlCandidato;
import Views.frmCandidato;
import Views.frmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrCandidato implements ActionListener {

    private ClsCandidato clscandidato = new ClsCandidato();
    private frmCandidato frmcandidato = new frmCandidato();
    private MdlCandidato mdlcandidato = new MdlCandidato();

    public CtrCandidato(ClsCandidato clscandidato, frmCandidato frmcandidato, MdlCandidato mdlcandidato) {
        this.clscandidato = clscandidato;
        this.frmcandidato = frmcandidato;
        this.mdlcandidato = mdlcandidato;
        this.frmcandidato.btnCanLimpiar.addActionListener(this);
        this.frmcandidato.btnCanActualizar.addActionListener(this);
        this.frmcandidato.btnCanGuardar.addActionListener(this);
        this.frmcandidato.btnCanEliminar.addActionListener(this);
        this.frmcandidato.btnCanBuscar.addActionListener(this);
        this.frmcandidato.btnCanRegresar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmcandidato.btnCanRegresar) {
            frmMenu frmmenu = new frmMenu();
            frmmenu.setVisible(true);
            frmcandidato.dispose();
        }

        if (e.getSource() == frmcandidato.btnCanGuardar) {
            validarCampos();
            ClsPartido clspartido = new ClsPartido();
            clscandidato.setDocumento(frmcandidato.txtCanDocumento.getText());
            clscandidato.setNombres(frmcandidato.txtCanNombres.getText());
            clscandidato.setApellidos(frmcandidato.txtCanApellidos.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            clscandidato.setFecha_nac(formato.format(frmcandidato.txtCanFecha.getDate()));
            clscandidato.setCelular(frmcandidato.txtCanCelular.getText());
            clscandidato.setEmail(frmcandidato.txtCanEmail.getText());
            String par = (String) frmcandidato.txtCanPartido.getSelectedItem();
            clscandidato.setPartidoPolitico(par);
            clscandidato.setCiudadOrigen(frmcandidato.txtCanCiudad.getText());
            clscandidato.setDescripcion(frmcandidato.txtCanDescripcion.getText());
            clscandidato.setMensajeCampana(frmcandidato.txtCanMensaje.getText());

            if (mdlcandidato.RegistrarPersonaCandidato(clscandidato)) {
                if (mdlcandidato.RegistrarCandidato(clscandidato)) {
                    JOptionPane.showMessageDialog(null, "Candidato agregado");
                    frmcandidato.listaCandidatos();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El candidato ya esta agregado");
                    limpiar();
                }
            } else {
                if (mdlcandidato.RegistrarCandidato(clscandidato)) {
                    JOptionPane.showMessageDialog(null, "Candidato agregado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El candidato ya esta agregado");
                    limpiar();
                }
            }

        }

        if (e.getSource() == frmcandidato.btnCanLimpiar) {
            limpiar();
        }

        if (e.getSource() == frmcandidato.btnCanBuscar) {
            if (frmcandidato.txtCanDocumento.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "El campo del documento es oligatorio", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            clscandidato.setDocumento(frmcandidato.txtCanDocumento.getText());
            if (mdlcandidato.buscarCandidato(clscandidato)) {
                frmcandidato.txtCanDocumento.setText(clscandidato.getDocumento());
                frmcandidato.txtCanNombres.setText(clscandidato.getNombres());
                frmcandidato.txtCanApellidos.setText(clscandidato.getApellidos());
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    frmcandidato.txtCanFecha.setDate(formato.parse(clscandidato.getFecha_nac()));
                } catch (ParseException ex) {
                    Logger.getLogger(CtrCandidato.class.getName()).log(Level.SEVERE, null, ex);
                }
                frmcandidato.txtCanCelular.setText(clscandidato.getCelular());
                frmcandidato.txtCanEmail.setText(clscandidato.getEmail());
                frmcandidato.txtCanPartido.setSelectedItem(clscandidato.getPartidoPolitico());
                frmcandidato.txtCanCiudad.setText(clscandidato.getCiudadOrigen());
                frmcandidato.txtCanDescripcion.setText(clscandidato.getDescripcion());
                frmcandidato.txtCanMensaje.setText(clscandidato.getMensajeCampana());
                frmcandidato.btnCanGuardar.setEnabled(false);
                frmcandidato.txtCanDocumento.setEnabled(false);
                frmcandidato.btnCanActualizar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe candidato con ese documento");
                limpiar();
            }
        }

        if (e.getSource() == frmcandidato.btnCanActualizar) {
            validarCampos();
            ClsPartido clspartido = new ClsPartido();
            clscandidato.setDocumento(frmcandidato.txtCanDocumento.getText());
            clscandidato.setNombres(frmcandidato.txtCanNombres.getText());
            clscandidato.setApellidos(frmcandidato.txtCanApellidos.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            clscandidato.setFecha_nac(formato.format(frmcandidato.txtCanFecha.getDate()));
            clscandidato.setCelular(frmcandidato.txtCanCelular.getText());
            clscandidato.setEmail(frmcandidato.txtCanEmail.getText());
            String par = (String) frmcandidato.txtCanPartido.getSelectedItem();
            clscandidato.setPartidoPolitico(par);
            clscandidato.setCiudadOrigen(frmcandidato.txtCanCiudad.getText());
            clscandidato.setDescripcion(frmcandidato.txtCanDescripcion.getText());
            clscandidato.setMensajeCampana(frmcandidato.txtCanMensaje.getText());

            if (mdlcandidato.ActualizarPersonaCandidato(clscandidato)) {
                if (mdlcandidato.ActualizarCandidato(clscandidato)) {
                    JOptionPane.showMessageDialog(null, "Candidato actualizado");
                    frmcandidato.listaCandidatos();
                    limpiar();
                }

            }
        }
    }

    public void validarCampos() {
        if (frmcandidato.txtCanDocumento.getText().equals("")
                || frmcandidato.txtCanNombres.getText().equals("")
                || frmcandidato.txtCanApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios por favor valide", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public void limpiar() {
        frmcandidato.btnCanGuardar.setEnabled(true);
        frmcandidato.txtCanDocumento.setEnabled(true);
        frmcandidato.btnCanActualizar.setEnabled(false);
        frmcandidato.txtCanDocumento.setText(null);
        frmcandidato.txtCanNombres.setText(null);
        frmcandidato.txtCanApellidos.setText(null);
        frmcandidato.txtCanFecha.setCalendar(null);
        frmcandidato.txtCanCelular.setText(null);
        frmcandidato.txtCanEmail.setText(null);
        frmcandidato.txtCanCiudad.setText(null);
        frmcandidato.txtCanDescripcion.setText(null);
        frmcandidato.txtCanMensaje.setText(null);

    }

}
