package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.PersonaDTO;
import ucacue.edu.ec.persistence.entity.Persona;
import ucacue.edu.ec.persistence.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service("personaServicelmpl")
public class PersonaServicelmpl extends GenericCRUDServiceImpl <Persona, PersonaDTO>  {

    @Autowired
    EstadoCivilServicelmpl estadoCivilServicelmpl;

    @Autowired
    GeneroServicelmpl generoServicelmpl;

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public Persona getOne(PersonaDTO domainObject) {
        return personaRepository.getOneByCedula(domainObject.getCedula());
    }

    @Override
    public Persona findByCedula(PersonaDTO domainObject) {
        return null;
    }

    @Override
    public Persona mapTo(PersonaDTO personaDTO) {

        Persona persona = new Persona();
            //Casada
            if(personaDTO.getPersona()!= null){
                persona.setPersona(getOne(personaDTO.getPersona()));
             }else {
                persona.setPersona(null);
            }
        persona.setCedula(personaDTO.getCedula());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTelefonoUno(personaDTO.getTelefonoUno());
        persona.setTelefonoDos(personaDTO.getTelefonoDos());
        persona.setFechaNace(DateUtils.getFechaFromStringddMMyyyy(personaDTO.getFechaNace()));
        persona.setGenero(generoServicelmpl.getOne(personaDTO.getGenero()));
        persona.setEstadoCivil(estadoCivilServicelmpl.getOne(personaDTO.getEstadoCivil()));



        return persona;
    }

    @Override
    public Optional<Persona> findExisting(PersonaDTO domainObject) {
        return Optional.empty();
    }

    @Override
    public PersonaDTO build(Persona persona) {

        PersonaDTO personaDTO = new PersonaDTO();
        PersonaDTO casadoDTO = new PersonaDTO();

        personaDTO.setCedula(persona.getCedula());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setDireccion(persona.getDireccion());
        personaDTO.setTelefonoUno(persona.getTelefonoUno());
        personaDTO.setTelefonoDos(persona.getTelefonoDos());
        personaDTO.setGenero(generoServicelmpl.build(persona.getGenero()));
        personaDTO.setEstadoCivil(estadoCivilServicelmpl.build(persona.getEstadoCivil()));
        personaDTO.setFechaNace(DateUtils.convertirGreggorianToDDMMYYYY(persona.getFechaNace().toString()));

        if (persona.getPersona()!=null) {

            casadoDTO.setCedula(persona.getPersona().getCedula());
            casadoDTO.setNombre(persona.getPersona().getNombre());
            casadoDTO.setApellido(persona.getPersona().getApellido());
            casadoDTO.setDireccion(persona.getPersona().getDireccion());
            casadoDTO.setTelefonoUno(persona.getPersona().getTelefonoUno());
            casadoDTO.setTelefonoDos(persona.getPersona().getTelefonoDos());
            casadoDTO.setGenero(generoServicelmpl.build(persona.getPersona().getGenero()));
            casadoDTO.setEstadoCivil(estadoCivilServicelmpl.build(persona.getPersona().getEstadoCivil()));
            casadoDTO.setFechaNace(DateUtils.convertirGreggorianToDDMMYYYY(persona.getPersona().getFechaNace().toString()));
            personaDTO.setPersona(casadoDTO);
        }else {
            personaDTO.setPersona(null);
        }

        return personaDTO;
    }


    @Override
    public List<PersonaDTO> findAll() {
        return null;
    }
}
