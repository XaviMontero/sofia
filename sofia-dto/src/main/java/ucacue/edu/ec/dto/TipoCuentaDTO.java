package ucacue.edu.ec.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
public class TipoCuentaDTO {
    @NotEmpty
    private  String descripcion;
}
