package cl.fonasa.autorizacionterceros.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    private ResponseHandler() {
        throw new IllegalStateException("Utility class");
    }
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj,String code) {
        Map<String, Object> map = new HashMap<>();

        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("code", code );

        return new ResponseEntity<>(map,status);
    }
}
