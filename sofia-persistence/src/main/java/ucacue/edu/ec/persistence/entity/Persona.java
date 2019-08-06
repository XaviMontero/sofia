package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Persona {
    private  String cedula;
    private  Persona persona;
    private  EstadoCivil estadoCivil;
    private  Genero genero;
    private  String nombre;
    private  String apellido;
    private Date fechanace;
    private  String telefonouno;
    private  String telefonodos;
    private  String direccion;
}
