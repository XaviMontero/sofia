package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.TrabajadorDTO;
import ucacue.edu.ec.dto.TransacionDTO;
import ucacue.edu.ec.persistence.entity.Transacion;
import ucacue.edu.ec.persistence.repository.TransacionRepository;

import java.util.List;
import java.util.Optional;
@Service("transaccionServicelmpl")
public class TransaccionServicelmpl extends   GenericCRUDServiceImpl <Transacion, TransacionDTO> {

    @Autowired
    TransacionRepository repository;
    @Autowired
    CuentaServicelmpl cuentaServicelmpl;
    @Autowired
    TrabajoServicelmpl trabajoServicelmpl;
    @Autowired
    TipoTransaccionServicelmpl transaccionServicelmpl;
    @Override
    public Transacion getOne(TransacionDTO transacionDTO) {
        return repository.getOneByCuentaId(transacionDTO.getCuentaDTO().getId());
    }

    @Override
    public Transacion findByCedula(TransacionDTO domainObject) {
        return null;
    }

    @Override
    public Transacion mapTo(TransacionDTO transacionDTO) {
        Transacion transacion = new Transacion();

        if (transacionDTO.getCuentaDTO().getId() != 1){
            transacion.setCuenta(cuentaServicelmpl.getOne(transacionDTO.getCuentaDTO()));
        }else {
            transacion.setCuenta(cuentaServicelmpl.findByCedula(transacionDTO.getCuentaDTO()));

        }

        transacion.setEstado_empresa(1);
        transacion.setTrabajador(trabajoServicelmpl.getOne(transacionDTO.getTrabajadorDTO()));
        transacion.setFecha(DateUtils.getFechaFromStringddMMyyyy(DateUtils.getFechaActual()));
        transacion.setTipoTransacion(transaccionServicelmpl.getOne(transacionDTO.getTipoTransacionDTO()));
        if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Depositos")){
            transacion.setMonto(transacionDTO.getMonto());
        }else   if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Retiros")){
            transacion.setMonto(-transacionDTO.getMonto());
        }else   if(transacionDTO.getTipoTransacionDTO().getDescripcion().equals("Interes")){
            transacion.setMonto(transacionDTO.getMonto());
        }
        return transacion;
    }

    @Override
    public TransacionDTO build(Transacion transacion) {
        TransacionDTO transacionDTO = new TransacionDTO();
        transacionDTO.setCuentaDTO(cuentaServicelmpl.build(transacion.getCuenta()));
        transacionDTO.setEstado_empresa(transacion.getEstado_empresa());
        transacionDTO.setFecha(DateUtils.convertirGreggorianToDDMMYYYY(transacion.getFecha().toString()));
        transacionDTO.setTipoTransacionDTO(transaccionServicelmpl.build(transacion.getTipoTransacion()));
        transacionDTO.setTrabajadorDTO(trabajoServicelmpl.build(transacion.getTrabajador()));
        transacionDTO.setMonto(transacion.getMonto());
        return transacionDTO;
    }

    @Override
    public Optional<Transacion> findExisting(TransacionDTO domainObject) {
        return Optional.empty();
    }

    @Override
    public List<TransacionDTO> findAll() {
    return  null;

    }
}
