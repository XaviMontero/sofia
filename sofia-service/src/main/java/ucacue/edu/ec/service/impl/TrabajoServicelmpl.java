package ucacue.edu.ec.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.exception.SofiaException;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.TrabajadorDTO;
import ucacue.edu.ec.persistence.entity.Persona;
import ucacue.edu.ec.persistence.entity.Trabajador;
import ucacue.edu.ec.persistence.repository.TabajadorRepository;

import java.util.List;
import java.util.Optional;

@Service("trabajoServicelmpl")
public class TrabajoServicelmpl extends   GenericCRUDServiceImpl <Trabajador, TrabajadorDTO> {

    @Autowired
    TabajadorRepository trabajadorRepository;

    @Autowired
    SucursalServicelmpl sucursalServicelmpl;

    @Autowired
    PersonaServicelmpl personaServicelmpl ;

    @Override
    public Trabajador getOne(TrabajadorDTO trabajadorDTO) {
        return trabajadorRepository.getOneByUsuarioAndPassword(trabajadorDTO.getUsuario(),trabajadorDTO.getPassword());
    }

    @Override
    public Trabajador findByCedula(TrabajadorDTO domainObject) {
        return null;
    }

    @Override
    public Trabajador mapTo(TrabajadorDTO trabajadorDTO) {

        Trabajador trabajador = new Trabajador();
        trabajador.setDescripcion(trabajadorDTO.getDescripcion());
        trabajador.setEstado(trabajadorDTO.getEstado());
        trabajador.setUsuario(trabajadorDTO.getUsuario());
        trabajador.setPassword(trabajadorDTO.getPassword());
        trabajador.setFechaEntrada(DateUtils.getFechaFromStringddMMyyyy(trabajadorDTO.getFechaEntrada()));
        trabajador.setSueldo(trabajadorDTO.getSueldo());
        Optional<Persona> optional = personaServicelmpl.findExisting(trabajadorDTO.getPersonaDTO());
        if (!optional.isPresent()) {
            trabajador.setPersona(personaServicelmpl.getOne(trabajadorDTO.getPersonaDTO()));
            trabajador.setSucursal(sucursalServicelmpl.getOne(trabajadorDTO.getSucursalDTO()));
        } else {
            throw new SofiaException(String.format("La cedula asignada al trabajador no existe "));
        }


        return trabajador;
    }

    @Override
    public TrabajadorDTO build(Trabajador domainObject) {
        return null;
    }

    @Override
    public Optional<Trabajador> findExisting(TrabajadorDTO trabajadorDTO) {
        return trabajadorRepository.findByPersonaCedula(trabajadorDTO.getPersonaDTO().getCedula());
    }

    @Override
    public List<TrabajadorDTO> findAll() {
        return null;
    }
}
