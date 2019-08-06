package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Cuenta {
    private  int idcuenta;
    private  Cliente cliente;
    private TipoCuenta tipoCuenta;
    private  Boolean estado;
    private Date fechacreacion;


}
