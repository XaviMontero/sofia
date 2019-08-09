package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "estado_civil")
public class EstadoCivil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_civil_generator")
    @SequenceGenerator(name = "estado_civil_generator", sequenceName = "estado_civil_id_seq", allocationSize = 100)
    @Column(name = "id_estado_civil", updatable = false, nullable = false)
    private  long id;

    @Column (name = "descripcion")
    private  String descripcion;


}
