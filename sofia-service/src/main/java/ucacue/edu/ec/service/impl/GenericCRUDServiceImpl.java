package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import ucacue.edu.ec.common.exception.SofiaException;
import ucacue.edu.ec.common.util.DateUtils;
import ucacue.edu.ec.dto.CuentaDTO;
import ucacue.edu.ec.dto.EstadoCuentaDTO;
import ucacue.edu.ec.persistence.entity.Cuenta;
import ucacue.edu.ec.persistence.repository.TransacionRepository;
import ucacue.edu.ec.service.GenericCRUDService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericCRUDServiceImpl <DOMAIN, DTO> implements GenericCRUDService<DOMAIN, DTO> {

    @Autowired
    private JpaRepository<DOMAIN, Long> repository;
    @Autowired
    TransacionRepository repositorys;
    @Override
    public void saveOrUpdate(DTO dtoObject) {
        Optional<DOMAIN> optional = findExisting(dtoObject);
        if (!optional.isPresent()) {
            DOMAIN domainObject = mapTo(dtoObject);
            repository.save(domainObject);
        } else {
            throw new SofiaException(String.format("El objeto %s ya existe en base de datos", dtoObject));
        }
    }

    @Override
    public List<DTO> findAll(DTO dtoObject) {
        DOMAIN domainObject = mapTo(dtoObject);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("id");
        List<DOMAIN> lstObjs = repository.findAll(Example.of(domainObject, matcher));
        return lstObjs.stream()
                .map(obj -> build(obj))
                .collect(Collectors.toList());
    }

    @Override
    public List<EstadoCuentaDTO> estadoCuenta(long doDto) {
        List<Object[]> objects=repositorys.estadoCuenta(doDto);
        List<EstadoCuentaDTO> reporte = new ArrayList<>();
        for (Object o[]:objects){
            EstadoCuentaDTO as = new EstadoCuentaDTO();
            Date fecha = (Date) o[0];
            as.setFecha(DateUtils.convertirGreggorianToDDMMYYYY(fecha.toString()));
            as.setDescripcion((String) o[1]);
            as.setMonto((BigDecimal) o[2]);
            as.setTotal((BigDecimal) o[3]);
            reporte.add(as);

        }
        return reporte;
    }

    @Override
    public abstract DOMAIN getOne(DTO domainObject);

    @Override
    public abstract DOMAIN mapTo(DTO domainObject);
    @Override
    public abstract DOMAIN findByCedula(DTO domainObject);
    @Override
    public abstract Optional<DOMAIN> findExisting(DTO domainObject);

    @Override
    public DOMAIN find(long id) {
        return repository.getOne(id);
    }


}
