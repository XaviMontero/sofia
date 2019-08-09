package ucacue.edu.ec.persistence.repository;

import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Genero;

import java.util.Optional;

@Repository
public interface GeneroRepository extends BaseRepository <Genero, Long> {
    @Override
    Optional<Genero> findById(long id);

    @Override
    Optional<Genero> findByDescripcion(String descripcion);

    @Override
    Genero getOneByDescripcion(String descripcion);


}
