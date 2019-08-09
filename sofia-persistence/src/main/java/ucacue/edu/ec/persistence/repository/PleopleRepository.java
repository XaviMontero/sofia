package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ucacue.edu.ec.persistence.entity.Genero;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface PleopleRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {

    public Optional<T> findByCedula(String cedula);
    public Optional<T> findByNombre(String nombre);
    public T getOneByCedula (String cedula);

}
