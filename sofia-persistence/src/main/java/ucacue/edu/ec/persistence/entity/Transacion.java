package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transacion")
public class Transacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacion_generator")
    @SequenceGenerator(name = "transacion_generator", sequenceName = "transacion_id_seq", allocationSize = 1)
    @Column(name = "id_transacion", updatable = false, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador")
    private Trabajador trabajador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_transacion", referencedColumnName = "id_tipo_transacion")
    private TipoTransacion tipoTransacion;

    @Column
    private Date fecha;

    @Column
    private double monto;

    @Column
    private int estado_empresa;



}
