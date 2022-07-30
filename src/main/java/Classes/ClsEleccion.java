
package Classes;


public class ClsEleccion {
    
    private String documentoVotante;
    private String documentoCandidato;
    private String fechaInicio;
    private String fechaFinal;
    private String nombres;
    private String apellidos;
    
    public ClsEleccion(){
        
    }

    public ClsEleccion(String documentoVotante, String documentoCandidato, String fechaInicio, String fechaFinal) {
        this.documentoVotante = documentoVotante;
        this.documentoCandidato = documentoCandidato;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getDocumentoVotante() {
        return documentoVotante;
    }

    public void setDocumentoVotante(String documentoVotante) {
        this.documentoVotante = documentoVotante;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    public ClsEleccion(String documentoCandidato, String nombres, String apellidos) {
        this.documentoCandidato = documentoCandidato;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDocumentoCandidato() {
        return documentoCandidato;
    }

    public void setDocumentoCandidato(String documentoCandidato) {
        this.documentoCandidato = documentoCandidato;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String toString(){
        return nombres + " " + apellidos;
    }

    
    
    
    
    
    
}
