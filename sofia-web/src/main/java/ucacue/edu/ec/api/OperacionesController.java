package ucacue.edu.ec.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucacue.edu.ec.dto.EstadoCivilDTO;
import ucacue.edu.ec.dto.PersonaDTO;
import ucacue.edu.ec.dto.SofiaResponseDTO;
import ucacue.edu.ec.persistence.entity.EstadoCivil;
import ucacue.edu.ec.persistence.entity.Persona;
import ucacue.edu.ec.service.GenericCRUDService;

import javax.validation.Valid;
import static ucacue.edu.ec.common.util.Constants.API_DOC_ANEXO_1;


@RestController
@RequestMapping(value = "/api/v1.0/operaciones")
@Api(description = "Modulo de operaciones ")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class OperacionesController {
    @Autowired
    @Qualifier("estadoCivilServicelmpl")
    private GenericCRUDService<EstadoCivil, EstadoCivilDTO> serviceEstado;

    @Autowired
    @Qualifier("personaServicelmpl")
    private GenericCRUDService<Persona, PersonaDTO> servicesPersona;


    @ApiOperation(value = "Almacena un estado civil ")
    @PostMapping(value = "estado-civil", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertEstadoCivil(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody EstadoCivilDTO estadoCivilDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        serviceEstado.saveOrUpdate(estadoCivilDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Almacena una persona")
    @PostMapping(value = "save-persona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertPersona(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody PersonaDTO personaDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        servicesPersona.saveOrUpdate(personaDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
