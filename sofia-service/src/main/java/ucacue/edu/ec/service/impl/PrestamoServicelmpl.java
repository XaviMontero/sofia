package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.CuentaDTO;
import ucacue.edu.ec.dto.GaranteDTO;
import ucacue.edu.ec.dto.PersonaDTO;
import ucacue.edu.ec.dto.PrestamoDTO;
import ucacue.edu.ec.persistence.entity.Cuenta;
import ucacue.edu.ec.persistence.entity.Garante;
import ucacue.edu.ec.persistence.entity.Persona;
import ucacue.edu.ec.persistence.entity.Prestamo;
import ucacue.edu.ec.persistence.repository.PrestamoRepository;
import ucacue.edu.ec.service.GenericCRUDService;

import java.util.List;
import java.util.Optional;

@Service("prestamoServicelmpl")
public class PrestamoServicelmpl extends  GenericCRUDServiceImpl <Prestamo, PrestamoDTO> {

    @Autowired
    @Qualifier("garanteServicelmpl")
    private GenericCRUDService<Garante, GaranteDTO> servicesGarante;

    @Autowired
    @Qualifier("cuentaServicelmpl")
    private GenericCRUDService<Cuenta, CuentaDTO> serviceCuenta;
    @Autowired
    private PrestamoRepository prestamoRepository;


    @Override
    public Prestamo getOne(PrestamoDTO domainObject) {
        return prestamoRepository.getOneByCuentaId(domainObject.getCuenta().getId()) ;
    }

    @Override
    public Prestamo mapTo(PrestamoDTO prestamoDTO) {
        Prestamo prestamo = new Prestamo();
        prestamo.setActividad(prestamoDTO.getActividad());
        prestamo.setDestino(prestamoDTO.getDestino());
        prestamo.setCargaFamiliar(prestamoDTO.getCargaFamiliar());
        prestamo.setEstado(prestamoDTO.getEstado());
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setPlazo(prestamoDTO.getPlazo());
        prestamo.setFechaPrestamo(DateUtils.getFechaFromStringddMMyyyy(prestamoDTO.getFechaPrestamo()));
        prestamo.setInteres(prestamoDTO.getInteres());
        prestamo.setIngreso(prestamoDTO.getIngreso());
        prestamo.setGaranteDos(servicesGarante.getOne(prestamoDTO.getGaranteDos()));
        prestamo.setGaranteUno(servicesGarante.getOne(prestamoDTO.getGaranteUno()));
        prestamo.setCuenta(serviceCuenta.getOne(prestamoDTO.getCuenta()));
        return prestamo;
    }

    @Override
    public PrestamoDTO build(Prestamo prestamoDTO) {
        PrestamoDTO prestamo = new PrestamoDTO();
        prestamo.setActividad(prestamoDTO.getActividad());
        prestamo.setDestino(prestamoDTO.getDestino());
        prestamo.setCargaFamiliar(prestamoDTO.getCargaFamiliar());
        prestamo.setEstado(prestamoDTO.getEstado());
        prestamo.setMonto(prestamoDTO.getMonto());
        prestamo.setPlazo(prestamoDTO.getPlazo());
        prestamo.setFechaPrestamo(DateUtils.convertirGreggorianToDDMMYYYY(prestamoDTO.getFechaPrestamo().toString()));
        prestamo.setInteres(prestamo.getInteres());
        prestamo.setIngreso(prestamo.getIngreso());
        prestamo.setGaranteDos(servicesGarante.build(prestamoDTO.getGaranteDos()));
        prestamo.setGaranteUno(servicesGarante.build(prestamoDTO.getGaranteUno()));
        prestamo.setCuenta(serviceCuenta.build(prestamoDTO.getCuenta()));

        return prestamo;
    }

    @Override
    public Prestamo findByCedula(PrestamoDTO domainObject) {
        return null;
    }

    @Override
    public Optional<Prestamo> findExisting(PrestamoDTO domainObject) {
        return prestamoRepository.findByCuentaIdAndEstado(domainObject.getCuenta().getId(),domainObject.getEstado());
    }

    @Override
    public List<PrestamoDTO> findAll() {
        return null;
    }
}
