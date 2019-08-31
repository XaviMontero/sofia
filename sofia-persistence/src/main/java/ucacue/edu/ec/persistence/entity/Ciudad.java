package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciudad_generator")
    @SequenceGenerator(name = "ciudad_generator", sequenceName = "ciudad_id_seq", allocationSize = 1)
    @Column(name = "id_ciudad", updatable = false, nullable = false)
    private  long id;

    @Column
    private  String descripcion;


    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sucursal> sucursals = new ArrayList<>();
}
