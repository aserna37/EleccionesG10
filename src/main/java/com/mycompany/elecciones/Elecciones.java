
package com.mycompany.elecciones;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsLogin;
import Classes.ClsPartido;
import Classes.ClsPersona;
import Classes.ClsVotante;
import Controllers.CtrCandidato;
import Controllers.CtrEleccion;
import Controllers.CtrLogin;
import Controllers.CtrMenu;
import Controllers.CtrVotante;
import Models.MdlCandidato;
import Models.MdlEleccion;
import Models.MdlLogin;
import Models.MdlPartido;
import Models.MdlVotante;
import Views.frmCandidato;
import Views.frmEleccion;
import Views.frmLogin;
import Views.frmMenu;
import Views.frmResultados;
import Views.frmVotantes;


public class Elecciones {

    public static void main(String[] args) {
     
        frmEleccion frmelecciones = new frmEleccion();
        ClsEleccion clseleccion = new ClsEleccion();
        MdlEleccion mdleleccion = new MdlEleccion();
        CtrEleccion ctreleccion = new CtrEleccion(clseleccion, frmelecciones, mdleleccion);
        
        frmResultados frmresultados = new frmResultados();
        
        
        ClsVotante clsvotante = new ClsVotante();
        frmVotantes frmvotantes = new frmVotantes();
        MdlVotante mdlvotante = new MdlVotante();
        CtrVotante ctrvotante = new CtrVotante(clsvotante, frmvotantes, mdlvotante);
        
        MdlPartido mdlpartido = new MdlPartido();
        ClsPartido clspartido = new ClsPartido();
                
        ClsPersona clspersona = new ClsPersona();
        ClsCandidato clscandidato = new ClsCandidato();
        frmCandidato frmcandidato = new frmCandidato();
        MdlCandidato mdlcandidato = new MdlCandidato();
        CtrCandidato ctrcandidato = new CtrCandidato(clscandidato, frmcandidato, mdlcandidato);
        
        frmMenu frmmenu = new frmMenu();
        CtrMenu ctrmenu = new CtrMenu(frmcandidato, frmvotantes, frmresultados, frmmenu);
               
        frmLogin frmlogin = new frmLogin();
        ClsLogin clslogin = new ClsLogin();
        MdlLogin mdllogin = new MdlLogin();
        CtrLogin ctrlogin = new CtrLogin(frmlogin, clslogin, mdllogin, frmmenu, frmelecciones);
        
        frmlogin.setVisible(true);
        
        
    }
}
