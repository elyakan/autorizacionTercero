package cl.fonasa.autorizacionterceros.util;

/**
 * @author monate
 * @version 1.0
 */
public class Constantes {

    // estados de exito de respuesta general portal prestadores gestion usuario
    public static final long ESTADO_MENSAJE_EXITOSO = 0;
    public static final long ESTADO_MENSAJE_ERRONEO = 1;

    // manejo para los mensajes del controller en general
    public static final String MENSAJE_ERROR_CONSULTA_GENERICO_EXCEPTION = "Ocurrio un error al consultar";
    public static final String MENSAJE_ERROR_PROCESO_GENERICO_EXCEPTION = "Ocurrio un error al procesar";
    public static final String ESTADO_EXITO_OPERACION = "OK";
    public static final String ESTADO_RECHAZO_OPERACION = "NOK";
    public static final String MENSAJE_CONSULTA_EXITOSA = "Consulta Exitosa";
    public static final String MENSAJE_CONSULTA_NO_EXITOSA = "Consulta No Trajo Registros";
    public static final String MENSAJE_PROCESO_EXITOSO = "Procesamiento Correcto";
    public static final String MENSAJE_PROCESO_NO_EXITOSO = "Procesamiento Incorrecto";
    public static final String APPLICATION_JSON_VALUE_UTF8 = "application/json;charset=UTF-8";
    public static final long CODIGO_HTTP_EXITO = 200;
    public static final long CODIGO_HTTP_ERROR = 500;

    // manejo mensaje exito servicios fonasa y sonda
    public static final long ESTADO_MENSAJE_EXITOSO_FONASA = 0;
    public static final long ESTADO_MENSAJE_NO_EXITOSO_FONASA = 1;
    public static final long ESTADO_MENSAJE_EXITOSO_SONDA = 1;
    public static final long ESTADO_MENSAJE_NO_EXITOSO_SONDA = 0;
}