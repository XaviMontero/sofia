package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.EstadoCivilDTO;
import ucacue.edu.ec.persistence.entity.EstadoCivil;
import ucacue.edu.ec.persistence.repository.EstadoCivilRepository;

import java.util.List;
import java.util.Optional;
@Service("estadoCivilServicelmpl")
public class EstadoCivilServicelmpl extends   GenericCRUDServiceImpl <EstadoCivil, EstadoCivilDTO>  {

    @Autowired
    EstadoCivilRepository estadoCivilRepository;

    @Override
    public EstadoCivil getOne(EstadoCivilDTO domainObject) {
        return estadoCivilRepository.getOneByDescripcion(domainObject.getDescripcion());
    }

    @Override
    public EstadoCivil mapTo(EstadoCivilDTO estadoCivilDTO) {

        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setDescripcion(estadoCivilDTO.getDescripcion());
        return estadoCivil;
    }

    @Override
    public EstadoCivilDTO build(EstadoCivil estadoCivil) {
        EstadoCivilDTO estadoCivilDTO = new EstadoCivilDTO();
        estadoCivilDTO.setDescripcion(estadoCivil.getDescripcion());
        return estadoCivilDTO;
    }


    @Override
    public Optional<EstadoCivil> findExisting(EstadoCivilDTO domainObject) {
        return estadoCivilRepository.findByDescripcion(domainObject.getDescripcion());
    }

    @Override
    public List<EstadoCivilDTO> findAll() {
        return null;
    }
}
