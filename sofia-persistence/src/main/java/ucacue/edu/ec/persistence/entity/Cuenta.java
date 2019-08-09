package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuenta_generator")
    @SequenceGenerator(name = "cuenta_generator", sequenceName = "cuenta_id_seq", allocationSize = 1000)
    @Column(name = "id_cuenta", updatable = false, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private  Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo", referencedColumnName ="id_tipo")
    private TipoCuenta tipocuenta;

    @Column
    private  Boolean estado;

    @Column
    private Date fechaCreacion;


}
