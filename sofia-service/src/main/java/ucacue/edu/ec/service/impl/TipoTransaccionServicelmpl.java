package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.TipoTransacionDTO;
import ucacue.edu.ec.persistence.entity.TipoTransacion;
import ucacue.edu.ec.persistence.repository.TipoTransaccionRepository;

import java.util.List;
import java.util.Optional;
@Service("tipoTransaccionServicelmpl")
public class TipoTransaccionServicelmpl extends   GenericCRUDServiceImpl <TipoTransacion, TipoTransacionDTO>  {
    @Autowired
    TipoTransaccionRepository repository;

    @Override
    public TipoTransacion getOne(TipoTransacionDTO tipoTransacionDTO) {
        return repository.getOneByDescripcion(tipoTransacionDTO.getDescripcion());
    }

    @Override
    public TipoTransacion findByCedula(TipoTransacionDTO domainObject) {
        return null;
    }

    @Override
    public TipoTransacion mapTo(TipoTransacionDTO tipoTransacionDTO) {
            TipoTransacion tipoTransacion = new TipoTransacion();
            tipoTransacion.setDescripcion(tipoTransacionDTO.getDescripcion());
        return tipoTransacion;
    }

    @Override
    public TipoTransacionDTO build(TipoTransacion tipoTransacion) {
        TipoTransacionDTO tipoTransacionDTO = new TipoTransacionDTO();
        tipoTransacionDTO.setDescripcion(tipoTransacion.getDescripcion());
        return null;
    }

    @Override
    public Optional<TipoTransacion> findExisting(TipoTransacionDTO domainObject) {
        return repository.findByDescripcion(domainObject.getDescripcion());
    }

    @Override
    public List<TipoTransacionDTO> findAll() {
        return null;
    }
}
