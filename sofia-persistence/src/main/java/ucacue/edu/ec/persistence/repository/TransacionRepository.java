package ucacue.edu.ec.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucacue.edu.ec.persistence.entity.Transacion;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface TransacionRepository  extends  BaseTransacionRepository <Transacion, Long> {


    @Override
    ArrayList<Transacion> findByCuentaId (long id );
    @Override
    List<Transacion> findByCuentaClientePersonaCedula(String cedula );

    @Override
    Transacion getOneByCuentaId(long id);

    @Override
    @Query(value = "SELECT  T.fecha, C.descripcion ,T.monto,(SELECT SUM(S.monto) FROM transacion S  WHERE S.id_transacion<=T.id_transacion and S.id_cuenta=?1 ) As total FROM public.transacion T INNER JOIN public.tipo_transacion C on C.id_tipo_transacion = T.id_tipo_transacion WHERE T.id_cuenta=?1 ORDER BY  T.fecha DESC ;",nativeQuery = true)
    List<Object[]> estadoCuenta(long id);
}
