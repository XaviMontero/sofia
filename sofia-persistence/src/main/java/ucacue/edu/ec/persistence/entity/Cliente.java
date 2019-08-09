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
    @OneToOne
    @JoinColumn(name = "cedula")
    private Persona persona;

    @Column
    private long calificacion;

}
