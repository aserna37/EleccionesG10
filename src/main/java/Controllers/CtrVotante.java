package Controllers;

import Classes.ClsVotante;
import Models.MdlVotante;
import Views.frmMenu;
import Views.frmVotantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrVotante implements ActionListener {

    private ClsVotante clsvotante = new ClsVotante();
    private frmVotantes frmvotantes = new frmVotantes();
    private MdlVotante mdlvotante = new MdlVotante();

    public CtrVotante(ClsVotante clsvotante, frmVotantes frmvotantes, MdlVotante mdlvotante) {
        this.clsvotante = clsvotante;
        this.frmvotantes = frmvotantes;
        this.mdlvotante = mdlvotante;
        this.frmvotantes.btnVotLimpiar.addActionListener(this);
        this.frmvotantes.btnVotActualizar.addActionListener(this);
        this.frmvotantes.btnVotGuardar.addActionListener(this);
        this.frmvotantes.btnVotEliminar.addActionListener(this);
        this.frmvotantes.btnVotBuscar.addActionListener(this);
        this.frmvotantes.btnVotRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmvotantes.btnVotRegresar) {
            frmMenu frmmenu = new frmMenu();
            frmmenu.setVisible(true);
            frmvotantes.dispose();
        }
        
        if (e.getSource() == frmvotantes.btnVotLimpiar) {
            limpiar();
        }
        
        if (e.getSource() == frmvotantes.btnVotGuardar) {
            validarCampos();
            ClsVotante clsvotante = new ClsVotante();
            clsvotante.setDocumento(frmvotantes.txtVotDocumento.getText());
            clsvotante.setNombres(frmvotantes.txtVotNombres.getText());
            clsvotante.setApellidos(frmvotantes.txtVotApellidos.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            clsvotante.setFecha_nac(formato.format(frmvotantes.txtVotFecha.getDate()));
            clsvotante.setCelular(frmvotantes.txtVotCelular.getText());
            clsvotante.setEmail(frmvotantes.txtVotEmail.getText());
            clsvotante.setEstado(frmvotantes.txtVotEstado.getText());
            

            if (mdlvotante.RegistrarPersonaVotante(clsvotante)) {
                if (mdlvotante.RegistrarVotante(clsvotante)) {
                    JOptionPane.showMessageDialog(null, "Votante agregado");
                    frmvotantes.listaVotantes();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El votante ya esta agregado");
                    limpiar();
                }
            } else {
                if (mdlvotante.RegistrarVotante(clsvotante)) {
                    JOptionPane.showMessageDialog(null, "Votante agregado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "El votante ya esta agregado");
                    limpiar();
                }
            }

        }
        
        
        
        if (e.getSource() == frmvotantes.btnVotBuscar) {
            if (frmvotantes.txtVotDocumento.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "El campo del documento es oligatorio", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            clsvotante.setDocumento(frmvotantes.txtVotDocumento.getText());
            if (mdlvotante.buscarVotante(clsvotante)) {
                frmvotantes.txtVotDocumento.setText(clsvotante.getDocumento());
                frmvotantes.txtVotNombres.setText(clsvotante.getNombres());
                frmvotantes.txtVotApellidos.setText(clsvotante.getApellidos());
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    frmvotantes.txtVotFecha.setDate(formato.parse(clsvotante.getFecha_nac()));
                } catch (ParseException ex) {
                    Logger.getLogger(CtrCandidato.class.getName()).log(Level.SEVERE, null, ex);
                }
                frmvotantes.txtVotCelular.setText(clsvotante.getCelular());
                frmvotantes.txtVotEmail.setText(clsvotante.getEmail());
                frmvotantes.btnVotGuardar.setEnabled(false);
                frmvotantes.txtVotDocumento.setEnabled(false);
                frmvotantes.btnVotActualizar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe votante con ese documento");
                limpiar();
            }
        }
        
        
        if (e.getSource() == frmvotantes.btnVotActualizar) {
            validarCampos();
            ClsVotante clsvotante = new ClsVotante();
            clsvotante.setDocumento(frmvotantes.txtVotDocumento.getText());
            clsvotante.setNombres(frmvotantes.txtVotNombres.getText());
            clsvotante.setApellidos(frmvotantes.txtVotApellidos.getText());
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            clsvotante.setFecha_nac(formato.format(frmvotantes.txtVotFecha.getDate()));
            clsvotante.setCelular(frmvotantes.txtVotCelular.getText());
            clsvotante.setEmail(frmvotantes.txtVotEmail.getText());
            clsvotante.setEstado(frmvotantes.txtVotEstado.getText());

            if (mdlvotante.ActualizarPersonaVotante(clsvotante)) {
                JOptionPane.showMessageDialog(null, "Votante actualizado");
                    frmvotantes.listaVotantes();
                    limpiar();
            }
        }

    }
    
    
    
    
    
    public void validarCampos() {
        if (frmvotantes.txtVotDocumento.getText().equals("")
                || frmvotantes.txtVotNombres.getText().equals("")
                || frmvotantes.txtVotApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios por favor valide", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    
    
    public void limpiar() {
        frmvotantes.btnVotGuardar.setEnabled(true);
        frmvotantes.txtVotDocumento.setEnabled(true);
        frmvotantes.btnVotActualizar.setEnabled(false);
        frmvotantes.txtVotDocumento.setText(null);
        frmvotantes.txtVotNombres.setText(null);
        frmvotantes.txtVotApellidos.setText(null);
        frmvotantes.txtVotFecha.setCalendar(null);
        frmvotantes.txtVotCelular.setText(null);
        frmvotantes.txtVotEmail.setText(null);
        

    }

}
