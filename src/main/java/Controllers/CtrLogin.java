package Controllers;

import Classes.ClsLogin;
import Models.MdlLogin;
import Views.frmEleccion;
import Views.frmLogin;
import Views.frmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class CtrLogin implements ActionListener {

    private frmLogin frmlogin;
    private ClsLogin clslogin;
    private MdlLogin mdllogin;
    private frmMenu frmmenu;
    private frmEleccion frmelecciones;

    public CtrLogin(frmLogin frmlogin, ClsLogin clslogin, MdlLogin mdllogin, frmMenu frmmenu, frmEleccion frmelecciones) {
        this.frmlogin = frmlogin;
        this.clslogin = clslogin;
        this.mdllogin = mdllogin;
        this.frmmenu = frmmenu;
        this.frmelecciones = frmelecciones;
        this.frmlogin.btnLoginSalir.addActionListener(this);
        this.frmlogin.btnIngresarLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmlogin.btnLoginSalir) {
            System.exit(0);
        }
        if (e.getSource() == frmlogin.btnIngresarLogin) {

            String username = frmlogin.txtusuario.getText();
            String contrasena = frmlogin.txtcontrasena.getText();
            String usuario = "admin";
            
            
            
            

            if ((username.length() == 0) || (contrasena.length() == 0)) {

                JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (username.equals(usuario) && contrasena.equals(usuario)) {
                frmmenu.setVisible(true);
                frmlogin.dispose();
            } else {

                clslogin.setUsername(username);
                if (mdllogin.validarLogin(clslogin)) {
                    String usu = clslogin.getUsername();
                    String estado = clslogin.getEstado();
                    if (usu.equals(contrasena)) {
                        if (estado.equals("0")) {
                            Date date = Calendar.getInstance().getTime();  
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
                            String fechaIni = dateFormat.format(date); 
                            frmelecciones.txteleFecIni.setText(fechaIni);
                            frmelecciones.txteleVot.setText(username);
                            frmelecciones.txteleFecIni.setVisible(false);
                            frmelecciones.txteleVot.setVisible(false);
                            frmelecciones.setVisible(true);
                            frmlogin.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "El votante ya realizo su elección", "Error",
                                    JOptionPane.INFORMATION_MESSAGE);
                            frmlogin.txtusuario.setText(null);
                            frmlogin.txtcontrasena.setText(null);
                            return;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales no admitidas", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                        frmlogin.txtusuario.setText(null);
                        frmlogin.txtcontrasena.setText(null);
                        return;
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "El votante no ha sido registrado", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    frmlogin.txtusuario.setText(null);
                    frmlogin.txtcontrasena.setText(null);
                    return;
                }

            }

        }
    }

}
