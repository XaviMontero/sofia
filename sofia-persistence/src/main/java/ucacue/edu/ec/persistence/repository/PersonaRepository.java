package ucacue.edu.ec.persistence.repository;

import ucacue.edu.ec.persistence.entity.Persona;

import java.util.Optional;

public interface PersonaRepository extends PleopleRepository <Persona, Long>  {
    @Override
    Optional<Persona> findByCedula(String cedula);

    @Override
    Persona getOneByCedula(String cedula);
}
