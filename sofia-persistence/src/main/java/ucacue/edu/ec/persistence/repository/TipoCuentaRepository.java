package ucacue.edu.ec.persistence.repository;

 import org.springframework.stereotype.Repository;
 import ucacue.edu.ec.persistence.entity.TipoCuenta;

 import java.util.Optional;

@Repository
public interface TipoCuentaRepository extends BaseRepository <TipoCuenta, Long> {

    @Override
    Optional<TipoCuenta> findById(long id);

    @Override
    Optional<TipoCuenta> findByDescripcion(String descripcion);

    @Override
    TipoCuenta getOneByDescripcion(String descripcion);
}
