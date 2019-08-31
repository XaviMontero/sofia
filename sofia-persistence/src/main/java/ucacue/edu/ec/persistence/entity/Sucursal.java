package ucacue.edu.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_generator")
    @SequenceGenerator(name = "sucursal_generator", sequenceName = "sucursal_id_seq", allocationSize = 1)
    @Column(name = "id_sucursal", updatable = false, nullable = false)
    private  long id;

    @Column
    private  String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;
}
