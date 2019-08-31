package ucacue.edu.ec.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EstadoCuentaDTO {

    private String fecha;
    private String descripcion;
    private BigDecimal monto;
    private BigDecimal total;

}
