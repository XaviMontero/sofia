package ucacue.edu.ec.persistence.repository;

import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Ciudad;

import java.util.Optional;

@Repository
public interface CiudadRepository  extends  BaseRepository <Ciudad, Long>{
    @Override
    Optional<Ciudad> findById(long id);

    @Override
    Ciudad getOneByDescripcion(String descripcion);

    @Override
    Optional<Ciudad> findByDescripcion(String descripcion);
}
