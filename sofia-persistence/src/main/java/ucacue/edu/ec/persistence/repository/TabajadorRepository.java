package ucacue.edu.ec.persistence.repository;

import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Trabajador;

import java.util.Optional;

@Repository
public interface TabajadorRepository extends  BaseRepository <Trabajador, Long> {



    @Override
    Optional<Trabajador> findById(long id);

    //De vuelta un trabajador
    Trabajador getOneByPersonaCedula(String cedula);

    //Desean crear un persona pero existe esa cedula
    Optional<Trabajador> findByPersonaCedula(String cedula);

    //login user pass

    Trabajador getOneByUsuarioAndPassword(String user, String password);



}
