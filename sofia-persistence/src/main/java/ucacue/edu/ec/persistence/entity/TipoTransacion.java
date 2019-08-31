package ucacue.edu.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tipo_transacion")
public class TipoTransacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_transacion_generator")
    @SequenceGenerator(name = "tipo_transacion_generator", sequenceName = "tipo_transacion_id_seq", allocationSize = 1)
    @Column(name = "id_tipo_transacion", updatable = false, nullable = false)
    private  long id;

    @Column
    private String descripcion;

}
