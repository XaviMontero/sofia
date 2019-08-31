package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_generator")
    @SequenceGenerator(name = "cliente_generator", sequenceName = "cliente_id_seq", allocationSize = 1)
    @Column(name = "id_cliente", updatable = false, nullable = false)
    private long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula", referencedColumnName ="cedula")
    private Persona persona;

    @Column
    private long calificacion;
    @Column
    private String descripcion;



}
