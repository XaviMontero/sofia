package ucacue.edu.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tipo_cuenta")
public class TipoCuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_cuenta_generator")
    @SequenceGenerator(name = "tipo_cuenta_generator", sequenceName = "tipo_cuenta_id_seq", allocationSize = 1000)
    @Column(name = "id_tipo", updatable = false, nullable = false)
    private  long id;


    @Column
    private  String descripcion;

    /*@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo_cuenta")
    private Set<Cuenta> set;*/
}
