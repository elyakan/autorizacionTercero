package cl.fonasa.autorizacionterceros.controllers;

import cl.fonasa.autorizacionterceros.response.ResponseHandler;
import cl.fonasa.autorizacionterceros.util.Constantes;
import org.springframework.web.bind.annotation.RequestBody;
import cl.fonasa.autorizacionterceros.repository.AutorizacionTercerosRepository;
import cl.fonasa.autorizacionterceros.model.AutorizacionTerceros;
import cl.fonasa.autorizacionterceros.dto.AutorizacionTercerosDTO;
import cl.fonasa.autorizacionterceros.services.AutorizacionTercerosService;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

@Slf4j
@RestController
@RequestMapping({"/api/"})
@CrossOrigin(
        origins = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH})
public class AutorizacionTercerosController {

    @Autowired
    AutorizacionTercerosService autorizacionTercerosService;
    @Autowired
    private AutorizacionTercerosRepository autorizacionTercerosRepository;

    public AutorizacionTercerosController(AutorizacionTercerosService autorizacionTercerosService) {
        this.autorizacionTercerosService = autorizacionTercerosService;
    }

    //LISTA TODOS LOS REGISTROS
    @GetMapping({"/listaTodos"})
    public ResponseEntity<Object> getAutorizacionTercerosAll() {
        try {
            List<AutorizacionTerceros> autorizacionTerceros = autorizacionTercerosService.getAutorizacionTercerosAll();
            return salida(autorizacionTerceros, autorizacionTerceros, "getAutorizacionTercerosAll");

        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //LISTA REGISTROS POR RUT BENEFICIARIO
    @GetMapping({"/histBen/{rutBeneficiario}"})
    public ResponseEntity<Object>  getAutorizacionTercerosHistBen(@PathVariable String rutBeneficiario) {
        try {
            List<AutorizacionTerceros> autorizacionTerceros = autorizacionTercerosService.getAllByRutBen(rutBeneficiario);
            return salida(autorizacionTerceros, autorizacionTerceros, "getAutorizacionTercerosHistBen");

        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //LISTA REGISTROS POR RUT TERCERO
    @GetMapping({"/histTer/{rutTercero}"})
    public ResponseEntity<Object> getAutorizacionTercerosHistTer(@PathVariable String rutTercero) {
        try {
            List<AutorizacionTerceros> autorizacionTerceros = autorizacionTercerosService.getAllByRutTer(rutTercero);
            return salida(autorizacionTerceros, autorizacionTerceros, "getAutorizacionTercerosHistTer");

        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //LISTA REGISTROS POR RUT EJECUTIVO
    @GetMapping({"/histEje/{rutEjecutivo}"})
    public ResponseEntity<Object> getAutorizacionTercerosHistEje(@PathVariable String rutEjecutivo) {
        try {

            List<AutorizacionTerceros> autorizacionTerceros = autorizacionTercerosService.getAllByRutEje(rutEjecutivo);
            return salida(autorizacionTerceros, autorizacionTerceros, "getAutorizacionTercerosHistEje");

        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //LISTA REGISTROS POR ID UNICO DE REGISTRO
    @GetMapping({"/detalleById/{id}"})
    public ResponseEntity<Object> geAutorizacionTerceros(@PathVariable Long id) {
        try{

            List<AutorizacionTerceros> arryAutorizacionTercero = new ArrayList<>();
            AutorizacionTerceros result = this.autorizacionTercerosService.getAutorizacionTercerosById(id);
            arryAutorizacionTercero.add(result);
            return salida(arryAutorizacionTercero, result, "geAutorizacionTerceros");
        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //AGREGA REGISTRO
    @PostMapping(
            value = "/creaTercero",
            produces = {Constantes.APPLICATION_JSON_VALUE_UTF8},
            consumes = {Constantes.APPLICATION_JSON_VALUE_UTF8})
    public ResponseEntity<Object> saveAutorizacionTerceros(@RequestBody AutorizacionTercerosDTO autorizacionTercerosDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();

            //DTO to Entity
            AutorizacionTerceros autorizacionTercerosRequest = modelMapper.map(autorizacionTercerosDTO, AutorizacionTerceros.class);

            //validacion para que no cree el mismo registro con rut beneficiario, rut tercero y estado
            Integer validaCreacion = this.autorizacionTercerosService.getValidaCreaTercero(autorizacionTercerosRequest.getRunTercero() ,autorizacionTercerosRequest.getRunBeneficiario(),  autorizacionTercerosRequest.getIdEstado());
            if(validaCreacion!=0){
                return ResponseHandler.generateResponse("Registro repetido, valide su información", HttpStatus.NOT_FOUND, null, "1");
            }

            //validacion para que no se inserte mas de tres terceros relacionados
            Integer validaMaxTercero = this.autorizacionTercerosService.getValidaMaxTercero(autorizacionTercerosRequest.getRunBeneficiario());
            if(validaMaxTercero>=3){
                return ResponseHandler.generateResponse("Máximo de terceros habilitados a sido superado, valide su información", HttpStatus.NOT_FOUND, null, "1");
            }

            //insert
            AutorizacionTerceros autorizacionTerceros = this.autorizacionTercerosService.insert(autorizacionTercerosRequest);

            // convert entity to DTO
            AutorizacionTercerosDTO autorizacionTercerosResponse = modelMapper.map(autorizacionTerceros, AutorizacionTercerosDTO.class);

            //genera array para salida
            List<AutorizacionTercerosDTO> arryAutorizacionTercero = new ArrayList<>();
            arryAutorizacionTercero.add(autorizacionTercerosResponse);

            return salida(arryAutorizacionTercero, autorizacionTercerosResponse, "saveAutorizacionTerceros");

        } catch (HttpStatusCodeException e) {
            return new ResponseEntity(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    //ACTUALIZA REGISTRO
    @PutMapping(
            value = "/actualizaTercero",
            produces = {Constantes.APPLICATION_JSON_VALUE_UTF8},
            consumes = {Constantes.APPLICATION_JSON_VALUE_UTF8})
    public ResponseEntity<Object> updateAutorizacionTerceros(@RequestBody AutorizacionTercerosDTO autorizacionTercerosDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            //DTO to Entity
            AutorizacionTerceros autorizacionTercerosRequest = modelMapper.map(autorizacionTercerosDTO, AutorizacionTerceros.class);

            //validacion para que no se inserte mas de tres terceros relacionados
            Integer validaMaxTercero = this.autorizacionTercerosService.getValidaMaxTercero(autorizacionTercerosRequest.getRunBeneficiario());
            System.out.print(validaMaxTercero);

            int id;
            Long lid;
            String rutTercero = autorizacionTercerosRequest.getRunTercero();
            String rutBeneficiario = autorizacionTercerosRequest.getRunBeneficiario();

            lid = this.autorizacionTercerosRepository.getIdByRutTerRutBen(rutTercero, rutBeneficiario);

            //obtiene el registro de base datos
            AutorizacionTerceros AutorizacionTercerosAux = this.autorizacionTercerosService.getAutorizacionTercerosById(lid);

            if(Integer.parseInt(autorizacionTercerosRequest.getIdEstado()) != Integer.parseInt(AutorizacionTercerosAux.getIdEstado()) ) {
                if(Integer.parseInt(autorizacionTercerosRequest.getIdEstado()) != 0 ) {
                    if (validaMaxTercero >= 3) {
                        return ResponseHandler.generateResponse("Máximo de terceros habilitados a sido superado, valide su información", HttpStatus.NOT_FOUND, null, "1");
                    }
                }
            }

            //insert
            AutorizacionTerceros autorizacionTerceros = this.autorizacionTercerosService.insert(autorizacionTercerosRequest);

            // convert entity to DTO
            AutorizacionTercerosDTO autorizacionTercerosResponse = modelMapper.map(autorizacionTerceros, AutorizacionTercerosDTO.class);

            //genera array para salida
            List<AutorizacionTercerosDTO> arryAutorizacionTercero = new ArrayList<>();
            arryAutorizacionTercero.add(autorizacionTercerosResponse);

            return salida(arryAutorizacionTercero, autorizacionTercerosResponse, "updateAutorizacionTerceros");
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    //ELIMINA REGISTRO
    @DeleteMapping(
                    value = "/eliminaTercero",
                    produces = {Constantes.APPLICATION_JSON_VALUE_UTF8},
                    consumes = {Constantes.APPLICATION_JSON_VALUE_UTF8})
    public ResponseEntity<Object>  deleteAutorizacionTerceros(@RequestBody AutorizacionTercerosDTO autorizacionTercerosDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            //DTO to Entity
            AutorizacionTerceros autorizacionTercerosRequest = modelMapper.map(autorizacionTercerosDTO, AutorizacionTerceros.class);

            //insert
            AutorizacionTerceros autorizacionTerceros = this.autorizacionTercerosService.insert(autorizacionTercerosRequest);

            // convert entity to DTO
            AutorizacionTercerosDTO autorizacionTercerosResponse = modelMapper.map(autorizacionTerceros, AutorizacionTercerosDTO.class);

            //genera array para salida
            List<AutorizacionTercerosDTO> arryAutorizacionTercero = new ArrayList<>();
            arryAutorizacionTercero.add(autorizacionTercerosResponse);

            return salida(arryAutorizacionTercero, autorizacionTercerosResponse, "deleteAutorizacionTerceros");
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    //FUNCION PARA SALIDA UNICA
    public ResponseEntity<Object> salida(Object obj, Object result, String fnc){
        try {
            String[] emptyArray = {};
            if(result!= null) {
                return ResponseHandler.generateResponse(fnc + ": transaccion exitosa!", HttpStatus.OK, obj , "0");
            }
            else
                return ResponseHandler.generateResponse(fnc + ": Sin data!", HttpStatus.OK, emptyArray , "1");

        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(fnc + " : "+ e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }

    //VALIDACION RUT COMPRADOR DE BONO ESTA REALACIONADO AL BENEFICIARIO COMO TERCERO
    @GetMapping({"/validaCompraBono/{rutComprador}/{rutBeneficiario}"})
    public ResponseEntity<Object> validaCompraBono(@PathVariable String rutComprador, @PathVariable String rutBeneficiario) {
        try {
            Integer valida = autorizacionTercerosService.getValidaCompraBono(rutComprador, rutBeneficiario);
            if(valida>=1)
                return ResponseHandler.generateResponse(valida.toString(), HttpStatus.OK, null, "0");
            else
                return ResponseHandler.generateResponse(valida.toString(), HttpStatus.NOT_FOUND, null, "1");
        } catch (HttpStatusCodeException e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.NOT_FOUND, null, "1");
        }
    }
}
