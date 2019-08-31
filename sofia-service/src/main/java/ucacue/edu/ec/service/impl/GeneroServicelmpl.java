package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.GeneroDTO;
import ucacue.edu.ec.persistence.entity.Genero;
import ucacue.edu.ec.persistence.repository.GeneroRepository;

import java.util.List;
import java.util.Optional;

@Service("generoServicelmpl")
public class GeneroServicelmpl  extends   GenericCRUDServiceImpl <Genero, GeneroDTO>  {

    @Autowired
    GeneroRepository generoRepository;

    @Override
    public Genero getOne(GeneroDTO domainObject) {
        return generoRepository.getOneByDescripcion(domainObject.getDescripcion());
    }

    @Override
    public Genero findByCedula(GeneroDTO domainObject) {
        return null;
    }

    @Override
    public Genero mapTo(GeneroDTO generoDTO) {
        Genero genero  = new Genero();
        genero.setDescripcion(generoDTO.getDescripcion());
        return genero;
    }

    @Override
    public GeneroDTO build(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setDescripcion(genero.getDescripcion());

        return generoDTO;
    }

    @Override
    public Optional<Genero> findExisting(GeneroDTO generoDTO) {
        return generoRepository.findByDescripcion(generoDTO.getDescripcion());
    }

    @Override
    public List<GeneroDTO> findAll() {
        return null;
    }


}
