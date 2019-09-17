package ucacue.edu.ec.persistence.entity;


 import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @Column(name = "cedula", updatable = false, nullable = false)
    private String cedula;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cedula", referencedColumnName = "cedula")
    private Persona persona;
  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
    private EstadoCivil estadoCivil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    private Genero genero;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Date fechaNace;

    @Column
    private String telefonoUno;

    @Column
    private  String telefonoDos;

    @Column
    private  String direccion;


    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Persona> personas = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabajador> trabajadors = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Garante> garantes = new ArrayList<>();



}
