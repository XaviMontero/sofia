package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Prestamo;

import java.util.Optional;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long>  {


    Optional<Prestamo> findByCuentaIdAndEstado(long id, int estado);

    Prestamo getOneByCuentaId(long id);
}
