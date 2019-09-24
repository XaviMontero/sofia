package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="prestamo_detalle")
public class PrestamoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamo_detalle_generator")
    @SequenceGenerator(name = "prestamo_detalle_generator", sequenceName = "prestamo_detalle_id_seq", allocationSize = 1)
    @Column(name = "id_prestamo_detalle", updatable = false, nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    private Prestamo prestamo;

    @Column
    private Date fechaAproxPago;
    @Column
    private Date fechaPago;
    @Column
    private int detalleNumero;
    @Column
    private double detalleCapitPagado;
    @Column
    private double detalleSaldoPemndiente;
    @Column
    private int estadoPago;
    @Column
    private double mora;
    @Column
    private double detalleCapital;
    @Column
    private double detalleTotal;

}
