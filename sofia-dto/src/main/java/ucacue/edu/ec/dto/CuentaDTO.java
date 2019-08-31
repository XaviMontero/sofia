package ucacue.edu.ec.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CuentaDTO {


    private  long id;

    private  ClienteDTO clienteDTO;

    private TipoCuentaDTO tipoCuentaDTO;

    private  int estado;

    private String fechaCreacion;

    private String descripcion;
}
