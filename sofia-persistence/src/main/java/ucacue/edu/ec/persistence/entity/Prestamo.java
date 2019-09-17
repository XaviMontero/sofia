package ucacue.edu.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prestamo_generator")
    @SequenceGenerator(name = "prestamo_generator", sequenceName = "prestamo_id_seq", allocationSize = 1)
    @Column(name = "id_prestamo", updatable = false, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_garante_uno", referencedColumnName = "id_garante")
    private Garante garanteUno;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_garante_dos", referencedColumnName = "id_garante")
    private Garante garanteDos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    private Cuenta cuenta;

    @Column
    private double monto;

    @Column
    private  int plazo;

    @Column
    private double interes;

    @Column
    private Date fechaPrestamo;

    @Column
    private String destino;

    @Column
    private String actividad;

    @Column
    private int cargaFamiliar;

    @Column
    private double ingreso;

    @Column
    private int estado;



 }
