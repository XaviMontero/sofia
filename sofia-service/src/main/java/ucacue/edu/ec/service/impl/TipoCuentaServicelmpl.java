package ucacue.edu.ec.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.TipoCuentaDTO;
import ucacue.edu.ec.persistence.entity.TipoCuenta;
import ucacue.edu.ec.persistence.repository.TipoCuentaRepository;

import java.util.List;
import java.util.Optional;
@Service("tipoCuentaServicelmpl")
public class TipoCuentaServicelmpl extends   GenericCRUDServiceImpl <TipoCuenta, TipoCuentaDTO>   {

    @Autowired
    TipoCuentaRepository repositoryTipo;

    @Override
    public TipoCuenta getOne(TipoCuentaDTO domainObject) {
        return repositoryTipo.getOneByDescripcion(domainObject.getDescripcion());
    }

    @Override
    public TipoCuenta mapTo(TipoCuentaDTO tipoCuentaDTO) {
        TipoCuenta tipoCuenta = new TipoCuenta();
        tipoCuenta.setDescripcion(tipoCuentaDTO.getDescripcion());
        return tipoCuenta;
    }

    @Override
    public TipoCuentaDTO build(TipoCuenta tipoCuenta) {
        TipoCuentaDTO tipoCuentaDTO = new TipoCuentaDTO();
        tipoCuentaDTO.setDescripcion(tipoCuenta.getDescripcion());
        return tipoCuentaDTO;
    }

    @Override
    public Optional<TipoCuenta> findExisting(TipoCuentaDTO tipoCuentaDTO) {
        return repositoryTipo.findByDescripcion(tipoCuentaDTO.getDescripcion());
    }

    @Override
    public List<TipoCuentaDTO> findAll() {
        return null;
    }
}
