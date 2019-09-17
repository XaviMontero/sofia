package ucacue.edu.ec.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PrestamoDTO {


    private GaranteDTO garanteUno;


    private GaranteDTO garanteDos;

    private CuentaDTO cuenta;

    private double monto;

    private  int plazo;

    private double interes;

    private String fechaPrestamo;

    private String destino;

    private String actividad;

    private int cargaFamiliar;

    private double ingreso;

    private int estado;

}
