package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "genero")
public class Genero implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_generator")
    @SequenceGenerator(name = "genero_generator", sequenceName = "genero_id_seq", allocationSize = 50)
    @Column(name = "id_genero", updatable = false, nullable = false)
    private  long id;

    @Column
    private  String descripcion;

    /*@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Persona> personas = new ArrayList<>();*/

}
