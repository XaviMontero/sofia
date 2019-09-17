package ucacue.edu.ec.persistence.repository;


import ucacue.edu.ec.persistence.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository  extends  BaseRepository <Cuenta, Long> {

    @Override
    Optional<Cuenta> findById(long id);


    Cuenta getOneById(long id);

    Cuenta getOneByClientePersonaCedula(String cedula);

    Optional<Cuenta>  getOneByTipocuentaDescripcionAndCliente_PersonaCedula(String descripcion,String cedula);

    @Override
    List<Cuenta> findAll();
}
