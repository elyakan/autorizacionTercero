package cl.fonasa.autorizacionterceros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.fonasa.autorizacionterceros.model.AutorizacionTerceros;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorizacionTercerosRepository  extends JpaRepository<AutorizacionTerceros ,Long> {


    /*
    Lista el ultimo movimiento por rut_beneficiario, rut_tercero, rut_ejecutivo,
    retorona el ultimo registro
    */
    @Query(value = "select ID,RUN_TERCERO,RUN_BENEFICIARIO,RUN_EJECUTIVO,NOMBRE_EJECUTIVO,ID_USUARIO,ID_ROL,CODIGO_DIRECCION_ZONAL,CODIGO_REGION,CODIGO_COMUNA,CODIGO_SUCURSAL,ID_ESTADO,FECHA_TRANS,FECHA_INICIO,FECHA_TERMINO,ID_TIPO_PARENTESCO,NOMBRE_TERCERO,PRIMER_AP_TERCERO,SEGUNDO_AP_TERCERO FROM TBLAUTORIZACIONTERCEROS where ID in (select max(a.ID ) FROM TBLAUTORIZACIONTERCEROS a GROUP BY a.RUN_TERCERO,a.RUN_BENEFICIARIO,a.RUN_EJECUTIVO )  order by ID",
            nativeQuery = true)
    List<AutorizacionTerceros> getAllByGroup();

    /*
    Lista historial por rut beneficiario
    */
    @Query(value = "select ID,RUN_TERCERO,RUN_BENEFICIARIO,RUN_EJECUTIVO,NOMBRE_EJECUTIVO,ID_USUARIO,ID_ROL,CODIGO_DIRECCION_ZONAL,CODIGO_REGION,CODIGO_COMUNA,CODIGO_SUCURSAL,ID_ESTADO,FECHA_TRANS,FECHA_INICIO,FECHA_TERMINO,ID_TIPO_PARENTESCO,NOMBRE_TERCERO,PRIMER_AP_TERCERO,SEGUNDO_AP_TERCERO FROM TBLAUTORIZACIONTERCEROS where RUN_BENEFICIARIO=?1 order by ID",
            nativeQuery = true)
    List<AutorizacionTerceros> getAllByRutBen(String rutBeneficiario);

    /*
    Lista historial por rut tercero
    */
    @Query(value = "select ID,RUN_TERCERO,RUN_BENEFICIARIO,RUN_EJECUTIVO,NOMBRE_EJECUTIVO,ID_USUARIO,ID_ROL,CODIGO_DIRECCION_ZONAL,CODIGO_REGION,CODIGO_COMUNA,CODIGO_SUCURSAL,ID_ESTADO,FECHA_TRANS,FECHA_INICIO,FECHA_TERMINO,ID_TIPO_PARENTESCO,NOMBRE_TERCERO,PRIMER_AP_TERCERO,SEGUNDO_AP_TERCERO FROM TBLAUTORIZACIONTERCEROS where RUN_TERCERO=?1 order by ID",
            nativeQuery = true)
    List<AutorizacionTerceros> getAllByRutTer(String rutTercero);

    /*
    Lista historial por rut ejecutivo
    */
    @Query(value = "select ID,RUN_TERCERO,RUN_BENEFICIARIO,RUN_EJECUTIVO,NOMBRE_EJECUTIVO,ID_USUARIO,ID_ROL,CODIGO_DIRECCION_ZONAL,CODIGO_REGION,CODIGO_COMUNA,CODIGO_SUCURSAL,ID_ESTADO,FECHA_TRANS,FECHA_INICIO,FECHA_TERMINO,ID_TIPO_PARENTESCO,NOMBRE_TERCERO,PRIMER_AP_TERCERO,SEGUNDO_AP_TERCERO FROM TBLAUTORIZACIONTERCEROS where RUN_EJECUTIVO=?1 order by ID",
            nativeQuery = true)
    List<AutorizacionTerceros> getAllByRutEje(String rutEjecutivo);

    @Query(value = "select count(1) FROM TBLAUTORIZACIONTERCEROS where RUN_TERCERO=?1 AND RUN_BENEFICIARIO=?2 AND ID_ESTADO=1",
            nativeQuery = true)
    Integer getValidaCompraBono(String rutComprador, String rutBeneficiario);

}
