package ucacue.edu.ec.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.dto.SucursalDTO;
import ucacue.edu.ec.persistence.entity.Sucursal;
import ucacue.edu.ec.persistence.repository.SucursalRepository;

import java.util.List;
import java.util.Optional;

@Service("sucursalServicelmpl")
public class SucursalServicelmpl extends   GenericCRUDServiceImpl <Sucursal, SucursalDTO>  {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private CiudadServicelmpl servicelmpl;

    @Override
    public Sucursal getOne(SucursalDTO sucursalDTO) {
        return sucursalRepository.getOneByDescripcion(sucursalDTO.getDescripcion());
    }

    @Override
    public Sucursal findByCedula(SucursalDTO domainObject) {
        return null;
    }

    @Override
    public Sucursal mapTo(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setDescripcion(sucursalDTO.getDescripcion());
        sucursal.setCiudad(servicelmpl.getOne(sucursalDTO.getCiudadDTO() ));


        return sucursal;
    }

    @Override
    public SucursalDTO build(Sucursal sucursal) {

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setDescripcion(sucursal.getDescripcion());
        sucursalDTO.setCiudadDTO(servicelmpl.build(sucursal.getCiudad()));
        return sucursalDTO;
    }

    @Override
    public Optional<Sucursal> findExisting(SucursalDTO sucursalDTO) {
        return sucursalRepository.findByDescripcion(sucursalDTO.getDescripcion());
    }

    @Override
    public List<SucursalDTO> findAll() {
        return null;
    }
}
