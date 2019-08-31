package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;
import java.util.List;


@NoRepositoryBean
public interface BaseTransacionRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> findByCuentaId (long id );
    List<T> findByCuentaClientePersonaCedula(String cedula );
    T getOneByCuentaId(long id);
    List<Object[]> estadoCuenta(long id);
}
