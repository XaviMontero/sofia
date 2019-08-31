package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.ClienteDTO;
import ucacue.edu.ec.persistence.entity.Cliente;
import ucacue.edu.ec.persistence.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service("clienteServicelmpl")
public class ClienteServicelmpl extends   GenericCRUDServiceImpl <Cliente, ClienteDTO> {

    @Autowired
    PersonaServicelmpl personaServicelmpl;
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public Cliente getOne(ClienteDTO clienteDTO) {

        return clienteRepository.getOneByPersonaCedula(clienteDTO.getPersonaDTO().getCedula()) ;
    }

    @Override
    public Cliente findByCedula(ClienteDTO domainObject) {
        return null;
    }

    @Override
    public Cliente mapTo(ClienteDTO clienteDTO) {
    Cliente cliente = new Cliente();
    cliente.setPersona(personaServicelmpl.getOne(clienteDTO.getPersonaDTO()));
    cliente.setCalificacion(clienteDTO.getCalificacion());
    cliente.setDescripcion(clienteDTO.getDescripcion());
        return cliente;
    }

    @Override
    public ClienteDTO build(Cliente cliente) {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setPersonaDTO(personaServicelmpl.build(cliente.getPersona()));
            clienteDTO.setCalificacion(cliente.getCalificacion());

        return clienteDTO;
    }

    @Override
    public Optional<Cliente> findExisting(ClienteDTO clienteDTO) {
        return clienteRepository.findByPersonaCedula(clienteDTO.getPersonaDTO().getCedula());
    }

    @Override
    public List<ClienteDTO> findAll() {
        return null;
    }
}
