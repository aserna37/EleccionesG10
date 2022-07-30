package Classes;

public class ClsCandidato extends ClsPersona {

    private String partidoPolitico;
    private String ciudadOrigen;
    private String descripcion;
    private String mensajeCampana;
    
    public ClsCandidato(){
        
    }

    public ClsCandidato(String partidoPolitico, String ciudadOrigen, String descripcion, String documento, String nombres, String apellidos, String fecha_nac, String celular, String email) {
        super(documento, nombres, apellidos, fecha_nac, celular, email);
        this.partidoPolitico = partidoPolitico;
        this.ciudadOrigen = ciudadOrigen;
        this.descripcion = descripcion;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeCampana() {
        return mensajeCampana;
    }

    public void setMensajeCampana(String mensajeCampana) {
        this.mensajeCampana = mensajeCampana;
    }

}
