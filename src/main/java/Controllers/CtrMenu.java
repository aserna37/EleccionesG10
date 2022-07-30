
package Controllers;

import Views.frmCandidato;
import Views.frmMenu;
import Views.frmResultados;
import Views.frmVotantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class CtrMenu extends JFrame implements ActionListener {
    
    private frmCandidato frmcandidato;
    private frmVotantes frmvotantes;
    private frmResultados frmresultados;
    private frmMenu frmmenu;

    public CtrMenu(frmCandidato frmcandidato, frmVotantes frmvotantes, frmResultados frmresultados, frmMenu frmmenu) {
        this.frmcandidato = frmcandidato;
        this.frmvotantes = frmvotantes;
        this.frmresultados = frmresultados;
        this.frmmenu = frmmenu;
        this.frmmenu.btnMenuSalir.addActionListener(this);
        this.frmmenu.btnMenuCandidatos.addActionListener(this);
        this.frmmenu.btnMenuVotantes.addActionListener(this);
        this.frmmenu.btnMenuResultados.addActionListener(this);
               
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmmenu.btnMenuSalir) {
            System.exit(0);
        }
        
        if (e.getSource() == frmmenu.btnMenuCandidatos) {
            frmcandidato.setVisible(true);
            frmmenu.dispose();
        }
        
        if (e.getSource() == frmmenu.btnMenuVotantes) {
            frmvotantes.setVisible(true);
            frmmenu.dispose();
        }
        
        if (e.getSource() == frmmenu.btnMenuResultados) {
            frmresultados.setVisible(true);
            frmmenu.dispose();
        }
    }
    
    
    
}
