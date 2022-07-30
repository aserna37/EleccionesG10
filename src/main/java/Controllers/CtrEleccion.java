
package Controllers;

import Classes.ClsEleccion;
import Models.MdlEleccion;
import Views.frmEleccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class CtrEleccion implements ActionListener{

    private ClsEleccion clseleccion = new ClsEleccion();
    private frmEleccion frmelecciones = new frmEleccion();
    private MdlEleccion mdleleccion = new MdlEleccion();

    public CtrEleccion(ClsEleccion clseleccion, frmEleccion frmelecciones, MdlEleccion mdleleccion) {
        
        this.clseleccion = clseleccion;
        this.frmelecciones = frmelecciones;
        this.mdleleccion = mdleleccion;
        this.frmelecciones.btnEleccionSalir.addActionListener(this);
        this.frmelecciones.btnEleVotar.addActionListener(this);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmelecciones.btnEleccionSalir) {
         System.exit(0);
        }
        
        if(e.getSource() == frmelecciones.btnEleVotar){
            ClsEleccion clseleccion = new ClsEleccion();
            clseleccion.setDocumentoVotante(frmelecciones.txteleVot.getText());
            clseleccion.setFechaInicio(frmelecciones.txteleFecIni.getText());
            String cedCan = frmelecciones.cbElecciones.getItemAt(frmelecciones.cbElecciones.getSelectedIndex()).getDocumentoCandidato();
            clseleccion.setDocumentoCandidato(cedCan);
            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
            String fechaFin = dateFormat.format(date);
            clseleccion.setFechaFinal(fechaFin);
            
            if (mdleleccion.RegistrarEleccion(clseleccion)) {
                if(mdleleccion.ActualizarEstadoVotante(clseleccion)){
                    
                    JOptionPane.showMessageDialog(null, "Gracias por votar!");
                    System.exit(0);
                }
                        } else {
                JOptionPane.showMessageDialog(null, "Verifique su voto");
            }
        }
        
    }
    
}
