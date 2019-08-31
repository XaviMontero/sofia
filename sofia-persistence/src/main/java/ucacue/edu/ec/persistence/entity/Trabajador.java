package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "trabajador")
public class Trabajador {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trabajador_generator")
    @SequenceGenerator(name = "trabajador_generator", sequenceName = "trabajador_id_seq", allocationSize = 1)
    @Column(name = "id_trabajador", updatable = false, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;

    @Column
    private Date fechaEntrada;

    @Column
    private double sueldo;

    @Column
    private int estado;

    @Column
    private String usuario;

    @Column
    private String password;

    @Column
    private String descripcion;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trabajador")
    private Set<Transacion> transacions;




}
