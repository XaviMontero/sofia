package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    public Optional<T> findById(long id);


    public Optional<T> findByDescripcion(String descripcion);

    public T getOneByDescripcion(String descripcion);


}
