package ucacue.edu.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "genero")
public class Genero {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_generator")
    @SequenceGenerator(name = "genero_generator", sequenceName = "genero_seq", allocationSize = 50)
    @Column(name = "id_genero", updatable = false, nullable = false)
    private  int idGenero;

    @Column
    private  String descripcion;

}
