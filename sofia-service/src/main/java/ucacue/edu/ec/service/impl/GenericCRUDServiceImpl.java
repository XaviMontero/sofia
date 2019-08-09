package ucacue.edu.ec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import ucacue.edu.ec.common.exception.SofiaException;
import ucacue.edu.ec.service.GenericCRUDService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericCRUDServiceImpl <DOMAIN, DTO> implements GenericCRUDService<DOMAIN, DTO> {

    @Autowired
    private JpaRepository<DOMAIN, Long> repository;

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
    public abstract DOMAIN getOne(DTO domainObject);

    @Override
    public abstract DOMAIN mapTo(DTO domainObject);

    @Override
    public abstract Optional<DOMAIN> findExisting(DTO domainObject);

    @Override
    public DOMAIN find(long id) {
        return repository.getOne(id);
    }


}
