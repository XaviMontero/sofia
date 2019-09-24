package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.PrestamoDetalle;

import java.util.List;
@Repository
public interface PrestamoDetalleRepository extends JpaRepository<PrestamoDetalle, Long> {
    @Override
    List <PrestamoDetalle> findAll();


}
