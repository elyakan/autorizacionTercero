package cl.fonasa.autorizacionterceros.services;
import java.util.List;
import cl.fonasa.autorizacionterceros.model.AutorizacionTerceros;
public interface AutorizacionTercerosService {

    List<AutorizacionTerceros> getAutorizacionTercerosAll();

    List<AutorizacionTerceros> getAllByRutBen(String rutBeneficiario);

    List<AutorizacionTerceros> getAllByRutTer(String rutTercero);

    List<AutorizacionTerceros> getAllByRutEje(String rutEjecutivo);

    AutorizacionTerceros getAutorizacionTercerosById(Long id);

    AutorizacionTerceros insert(AutorizacionTerceros autorizacionTerceros);

    AutorizacionTerceros updateAutorizacionTerceros(AutorizacionTerceros autorizacionTerceros);

    AutorizacionTerceros deleteAutorizacionTerceros(AutorizacionTerceros autorizacionTerceros);

    Integer getValidaCompraBono(String rutComprador, String rutBeneficiario);

    Integer getValidaCreaTercero(String rutComprador, String rutBeneficiario, String estado);

    Integer getValidaMaxTercero(String rutBeneficiario);

    Long getIdByRutTerRutBen(String rutTercero, String rutBeneficiario);

}
