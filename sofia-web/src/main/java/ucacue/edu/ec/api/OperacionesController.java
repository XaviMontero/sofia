package ucacue.edu.ec.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucacue.edu.ec.dto.*;
import ucacue.edu.ec.persistence.entity.*;
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
    @Autowired
    @Qualifier("clienteServicelmpl")
    private GenericCRUDService<Cliente, ClienteDTO> servicesCliente;
    @Autowired
    @Qualifier("cuentaServicelmpl")
    private GenericCRUDService<Cuenta, CuentaDTO> serviceCuenta;

    @Autowired
    @Qualifier("trabajoServicelmpl")
    private GenericCRUDService<Trabajador, TrabajadorDTO> serviceTrabajador;


    @Autowired
    @Qualifier("garanteServicelmpl")
    private GenericCRUDService<Garante, GaranteDTO> serviceGarante;

    @Autowired
    @Qualifier("prestamoServicelmpl")
    private GenericCRUDService<Prestamo, PrestamoDTO> servicePrestamo;

    @Autowired
    @Qualifier("transaccionServicelmpl")
    private GenericCRUDService<Transacion, TransacionDTO> seviceTransacion;
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

    @ApiOperation(value = "Almacena un Cliente")
    @PostMapping(value = "save-cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertCliente(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody ClienteDTO clienteDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        servicesCliente.saveOrUpdate(clienteDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Almacena un Garante")
    @PostMapping(value = "save-garante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertGarante(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody GaranteDTO garanteDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        serviceGarante.saveOrUpdate(garanteDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Almacena una Cuenta")
    @PostMapping(value = "save-cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertCuenta(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody CuentaDTO cuentaDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        serviceCuenta.saveOrUpdate(cuentaDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

        @ApiOperation(value = "Almacena un trabajador")
        @PostMapping(value = "save-trabajador", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Object> insertTrabajador(
                @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody TrabajadorDTO trabajadorDTO) {
            SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
            serviceTrabajador.saveOrUpdate(trabajadorDTO);
            response.setSuccess(true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

    @ApiOperation(value = "Devolver una persona   ")
    @GetMapping(value = "{cedula}/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> reportesZona(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("cedula") String cedula
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        PersonaDTO p = new PersonaDTO();
        p.setCedula(cedula);
        Persona p1=servicesPersona.getOne(p);
        if (p1!= null) {

            return (new ResponseEntity<Object>(servicesPersona.build(p1), headers, HttpStatus.OK));
        }else {
            SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();

            response.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Almacena una transaccion")
    @PostMapping(value = "save-transaccion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertTrasacion(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody TransacionDTO transacionDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        seviceTransacion.saveOrUpdate(transacionDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Devolver estado cuenta  ")
    @GetMapping(value = "{id}/estado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> estadoCuenta(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("id") long id
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(seviceTransacion.estadoCuenta(id), headers, HttpStatus.OK));

    }



    @ApiOperation(value = "Devolver un garante  ")
    @GetMapping(value = "{cedula}/garante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getGarante(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("cedula") String cedula
    ){
        PersonaDTO p = new PersonaDTO();
        p.setCedula(cedula);
        GaranteDTO garanteDTO  = new GaranteDTO();
        garanteDTO.setPersonaDTO(p);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(serviceGarante.build(serviceGarante.getOne(garanteDTO)), headers, HttpStatus.OK));

    }
    @ApiOperation(value = "Devolver una cuenta  mediante la cedula  ")
    @GetMapping(value = "{cedula}/cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCliente(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("cedula") String cedula
    ){
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setCedula(cedula);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setPersonaDTO(personaDTO);
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setClienteDTO(clienteDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(serviceCuenta.build(serviceCuenta.findByCedula(cuentaDTO)), headers, HttpStatus.OK));

    }
    @ApiOperation(value = "Devolver una cuenta mediante id  ")
    @GetMapping(value = "{id}/cuenta-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienteId(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("id") long id
    ){
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(serviceCuenta.build(serviceCuenta.getOne(cuentaDTO)), headers, HttpStatus.OK));

    }
    @ApiOperation(value = "Devolver Todos los clientes")
    @GetMapping(value = "/cuenta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getClienes( ){

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(serviceCuenta.findAll(), headers, HttpStatus.OK));

    }

    @ApiOperation(value = "Devolver un prestamo  ")
    @GetMapping(value = "{id}/prestamo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPrestamo(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("id") long id
    ){
        CuentaDTO cuentaDTO = new CuentaDTO();
        cuentaDTO.setId(id);
        PrestamoDTO p = new PrestamoDTO();
        p.setCuenta(cuentaDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(servicePrestamo.build(servicePrestamo.getOne(p)), headers, HttpStatus.OK));

    }


    @ApiOperation(value = "Almacena un prestamo cabecera ")
    @PostMapping(value = "save-prestamo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertPrestamo(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody PrestamoDTO prestamoDTO) {
        SofiaResponseDTO<Object> response = new SofiaResponseDTO<>();
        servicePrestamo.saveOrUpdate(prestamoDTO);
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
