
package Classes;


public class ClsVotante extends ClsPersona{
    
    private String estado;

    public ClsVotante() {
       
    }

    public ClsVotante(String estado, String documento, String nombres, String apellidos, String fecha_nac, String celular, String email) {
        super(documento, nombres, apellidos, fecha_nac, celular, email);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
}
