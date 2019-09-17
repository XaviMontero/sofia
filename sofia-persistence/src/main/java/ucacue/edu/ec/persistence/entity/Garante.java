package ucacue.edu.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="garante")
public class Garante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garante_generator")
    @SequenceGenerator(name = "garante_generator", sequenceName = "garante_id_seq", allocationSize = 1)
    @Column(name = "id_garante", updatable = false, nullable = false)
    private  long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;

    @Column
    private  String actividadDesepenio;

    @Column
    private  int activo;


}
