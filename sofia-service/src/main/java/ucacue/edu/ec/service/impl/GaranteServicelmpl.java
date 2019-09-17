package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.EstadoCivilDTO;
import ucacue.edu.ec.dto.GaranteDTO;
import ucacue.edu.ec.dto.PersonaDTO;
import ucacue.edu.ec.persistence.entity.EstadoCivil;
import ucacue.edu.ec.persistence.entity.Garante;
import ucacue.edu.ec.persistence.entity.Persona;
import ucacue.edu.ec.persistence.repository.GaranteRepository;
import ucacue.edu.ec.service.GenericCRUDService;

import java.util.List;
import java.util.Optional;

@Service("garanteServicelmpl")
public class GaranteServicelmpl extends  GenericCRUDServiceImpl <Garante, GaranteDTO>{

    @Autowired
    private GaranteRepository garanteRepository;


    @Autowired
    @Qualifier("personaServicelmpl")
    private GenericCRUDService<Persona, PersonaDTO> servicesPersona;

    @Override
    public Garante getOne(GaranteDTO domainObject) {
        return garanteRepository.getOneByPersonaCedula(domainObject.getPersonaDTO().getCedula());
    }

    @Override
    public Garante mapTo(GaranteDTO garanteDTO) {
        Garante garante = new Garante();
        garante.setActivo(1);
        garante.setActividadDesepenio(garanteDTO.getActividadDesepenio());
        garante.setPersona(servicesPersona.getOne(garanteDTO.getPersonaDTO()));

        return garante;
    }

    @Override
    public GaranteDTO build(Garante garante) {
        GaranteDTO garanteDTO= new GaranteDTO();
        garanteDTO.setActividadDesepenio(garante.getActividadDesepenio());
        garanteDTO.setPersonaDTO(servicesPersona.build(garante.getPersona()));
        garanteDTO.setActivo(garante.getActivo());
        return garanteDTO;
    }

    @Override
    public Garante findByCedula(GaranteDTO domainObject) {
        return garanteRepository.getOneByPersonaCedula(domainObject.getPersonaDTO().getCedula());
    }

    @Override
    public Optional<Garante> findExisting(GaranteDTO domainObject) {
        return garanteRepository.findByPersonaCedula(domainObject.getPersonaDTO().getCedula());
    }

    @Override
    public List<GaranteDTO> findAll() {
        return null;
    }
}
