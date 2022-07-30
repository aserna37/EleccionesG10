
package Classes;

public class ClsPersona {
    
    private String documento;
    private String nombres;
    private String apellidos;
    private String fecha_nac;
    private String celular;
    private String email;
    
    public ClsPersona(){
        
    }

    public ClsPersona(String documento, String nombres, String apellidos, String fecha_nac, String celular, String email) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
