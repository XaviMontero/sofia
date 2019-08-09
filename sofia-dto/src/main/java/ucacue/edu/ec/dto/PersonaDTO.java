package ucacue.edu.ec.dto;

 import lombok.Getter;
 import lombok.Setter;


@Getter
@Setter
public class PersonaDTO {


    private String cedula;

    private PersonaDTO persona;


    private EstadoCivilDTO estadoCivil;


    private GeneroDTO genero;


    private String nombre;


    private String apellido;


    private String fechaNace;


    private String telefonoUno;


    private  String telefonoDos;


    private  String direccion;

}
