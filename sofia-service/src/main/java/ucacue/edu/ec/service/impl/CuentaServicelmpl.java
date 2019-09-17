package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.CuentaDTO;
import ucacue.edu.ec.persistence.entity.Cuenta;
import ucacue.edu.ec.persistence.repository.CuentaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service("cuentaServicelmpl")
public class CuentaServicelmpl extends   GenericCRUDServiceImpl <Cuenta, CuentaDTO>  {

    @Autowired
    ClienteServicelmpl clienteServicelmpl;

    @Autowired
    TipoCuentaServicelmpl cuentaServicelmpl;

    @Autowired
    CuentaRepository cuentaRepository;



    @Override
    public Cuenta getOne(CuentaDTO cuentaDTO) {
        return cuentaRepository.getOneById(cuentaDTO.getId());
    }

    @Override
    public Cuenta mapTo(CuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCliente(clienteServicelmpl.getOne(cuentaDTO.getClienteDTO()));
        cuenta.setEstado(cuentaDTO.getEstado());
        cuenta.setFechaCreacion(DateUtils.getFechaFromStringddMMyyyy(DateUtils.getFechaActual()));
        cuenta.setTipocuenta(cuentaServicelmpl.getOne(cuentaDTO.getTipoCuentaDTO()));
        cuenta.setDescripcion(cuentaDTO.getDescripcion());

        return cuenta;
    }

    @Override
    public CuentaDTO build(Cuenta cuenta) {
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(cuenta.getId());
        cuentaDTO.setEstado(cuenta.getEstado());
        cuentaDTO.setFechaCreacion(DateUtils.convertirGreggorianToDDMMYYYY(cuenta.getFechaCreacion().toString()));
        cuentaDTO.setClienteDTO(clienteServicelmpl.build(cuenta.getCliente()));
        cuentaDTO.setTipoCuentaDTO(cuentaServicelmpl.build(cuenta.getTipocuenta()));
        cuentaDTO.setDescripcion(cuenta.getDescripcion());
        return cuentaDTO;
    }

    @Override
    public Optional<Cuenta> findExisting(CuentaDTO cuentaDTO) {
        return cuentaRepository.getOneByTipocuentaDescripcionAndCliente_PersonaCedula(
                cuentaDTO.getTipoCuentaDTO().getDescripcion(),
                cuentaDTO.getClienteDTO().getPersonaDTO().getCedula());

    }

    @Override
    public List<CuentaDTO> findAll() {
        List<CuentaDTO> cuentaDTOS = new ArrayList<>();
        for (Cuenta recupera : cuentaRepository.findAll()){

            cuentaDTOS.add(build(recupera));
        }
        return cuentaDTOS;
    }
    @Override
    public Cuenta findByCedula (CuentaDTO cuentaDTO){

        return cuentaRepository.getOneByClientePersonaCedula(cuentaDTO.getClienteDTO().getPersonaDTO().getCedula());


    }
}
