package ucacue.edu.ec.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.CiudadDTO;
import ucacue.edu.ec.persistence.entity.Ciudad;
import ucacue.edu.ec.persistence.repository.CiudadRepository;
import java.util.List;
import java.util.Optional;

@Service("ciudadServicelmpl")
public class CiudadServicelmpl extends   GenericCRUDServiceImpl <Ciudad, CiudadDTO> {

    @Autowired
    CiudadRepository ciudadRepository;
    @Override
    public Ciudad getOne(CiudadDTO ciudadDTO) {
        return ciudadRepository.getOneByDescripcion(ciudadDTO.getDescripcion());
    }

    @Override
    public Ciudad findByCedula(CiudadDTO domainObject) {
        return null;
    }

    @Override
    public Ciudad mapTo(CiudadDTO ciudadDTO) {
        Ciudad ciudad = new Ciudad();
        ciudad.setDescripcion(ciudadDTO.getDescripcion());
        return ciudad;
    }

    @Override
    public CiudadDTO build(Ciudad ciudad) {
        CiudadDTO ciudadDTO = new CiudadDTO();
        ciudadDTO.setDescripcion(ciudad.getDescripcion());
        return ciudadDTO;
    }

    @Override
    public Optional<Ciudad> findExisting(CiudadDTO ciudadDTO) {
        return  ciudadRepository.findByDescripcion(ciudadDTO.getDescripcion());
    }

    @Override
    public List<CiudadDTO> findAll() {
        return null;
    }
}
