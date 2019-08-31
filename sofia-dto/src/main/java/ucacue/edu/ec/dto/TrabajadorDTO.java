package ucacue.edu.ec.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrabajadorDTO {

    private PersonaDTO personaDTO;
    private SucursalDTO sucursalDTO;
    private String fechaEntrada;
    private double sueldo;
    private int estado;
    private String usuario;
    private String password;
    private String descripcion;

}
