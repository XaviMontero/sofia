package ucacue.edu.ec.persistence.repository;

import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Cliente;

import java.util.Optional;


@Repository
public interface  ClienteRepository extends  BaseRepository <Cliente, Long> {
    @Override
    Optional<Cliente> findById(long id);

    @Override
    Optional<Cliente> findByDescripcion(String descripcion);


    Optional<Cliente> findByPersonaCedula(String cedula);

    Cliente getOneByPersonaCedula(String cedula);
}
