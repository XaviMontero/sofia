package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.PrestamoDTO;
import ucacue.edu.ec.dto.PrestamoDetalleDTO;
import ucacue.edu.ec.persistence.entity.PrestamoDetalle;
import ucacue.edu.ec.persistence.repository.PrestamoDetalleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("prestamoDetalleServicelmpl")
public class PrestamoDetalleServicelmpl  extends  GenericCRUDServiceImpl <PrestamoDetalle, PrestamoDetalleDTO>{

    @Autowired
    private PrestamoServicelmpl prestamoServicelmpl;
    @Autowired
    private PrestamoDetalleRepository prestamoDetalleRepository;
    @Override
    public PrestamoDetalle getOne(PrestamoDetalleDTO domainObject) {
        return null;
    }

    @Override
    public PrestamoDetalle mapTo(PrestamoDetalleDTO domainObject) {
        return null;
    }

    @Override
    public PrestamoDetalleDTO build(PrestamoDetalle prestamoDetalle) {
        PrestamoDetalleDTO prestamoDetalleDTO = new PrestamoDetalleDTO();
        prestamoDetalleDTO.setPrestamo(prestamoServicelmpl.build(prestamoDetalle.getPrestamo()));
        prestamoDetalleDTO.setFechaAproxPago(DateUtils.convertirGreggorianToDDMMYYYY(prestamoDetalle.getFechaAproxPago().toString()));
        prestamoDetalleDTO.setFechaPago(DateUtils.convertirGreggorianToDDMMYYYY(prestamoDetalle.getFechaPago().toString()));
        prestamoDetalleDTO.setDetalleNumero(prestamoDetalle.getDetalleNumero());
        prestamoDetalleDTO.setDetalleCapitPagado(prestamoDetalle.getDetalleCapitPagado());
        prestamoDetalleDTO.setDetalleSaldoPemndiente(prestamoDetalle.getDetalleSaldoPemndiente());

        prestamoDetalleDTO.setEstadoPago(prestamoDetalle.getEstadoPago());
        prestamoDetalleDTO.setMora(prestamoDetalle.getMora());
        prestamoDetalleDTO.setDetalleCapital(prestamoDetalle.getDetalleCapital());
        prestamoDetalleDTO.setDetalleTotal(prestamoDetalle.getDetalleTotal());

        return prestamoDetalleDTO;
    }

    @Override
    public PrestamoDetalle findByCedula(PrestamoDetalleDTO domainObject) {
        return null;
    }

    @Override
    public Optional<PrestamoDetalle> findExisting(PrestamoDetalleDTO domainObject) {
        return Optional.empty();
    }

    @Override
    public List<PrestamoDetalleDTO> findAll() {
        List<PrestamoDetalleDTO> prestamoDetalleDTOS = new ArrayList<>();
        for (PrestamoDetalle prestamoDetalle :prestamoDetalleRepository.findAll() ){
            prestamoDetalleDTOS.add(build(prestamoDetalle));

        }
        return prestamoDetalleDTOS;
    }
}
