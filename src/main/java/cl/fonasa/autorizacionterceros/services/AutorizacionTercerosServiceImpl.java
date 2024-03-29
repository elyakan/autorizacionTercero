package cl.fonasa.autorizacionterceros.services;

import java.util.List;
import org.springframework.stereotype.Service;
import cl.fonasa.autorizacionterceros.model.AutorizacionTerceros;
import cl.fonasa.autorizacionterceros.repository.AutorizacionTercerosRepository;
@Service
public class AutorizacionTercerosServiceImpl implements AutorizacionTercerosService{

    AutorizacionTercerosRepository autorizacionTercerosRepository;

    public AutorizacionTercerosServiceImpl(AutorizacionTercerosRepository autorizacionTercerosRepository) {
        this.autorizacionTercerosRepository = autorizacionTercerosRepository;
    }


    public List<AutorizacionTerceros> getAutorizacionTercerosAll() {
        return autorizacionTercerosRepository.getAllByGroup();
    }

    public List<AutorizacionTerceros> getAllByRutBen(String rutBeneficario) {
        return autorizacionTercerosRepository.getAllByRutBen(rutBeneficario);
    }

    public List<AutorizacionTerceros> getAllByRutTer(String rutTercero) {
        return autorizacionTercerosRepository.getAllByRutTer(rutTercero);
    }
    public Integer getValidaCompraBono(String rutComprador, String rutBeneficario) {
        return autorizacionTercerosRepository.getValidaCompraBono(rutComprador, rutBeneficario);
    }

    public Integer getValidaCreaTercero(String rutTercero, String rutBeneficario, String estado) {
        return autorizacionTercerosRepository.getValidaCreaTercero(rutTercero, rutBeneficario, estado);
    }

    public Integer getValidaMaxTercero(String rutBeneficario) {
        return autorizacionTercerosRepository.getValidaMaxTercero(rutBeneficario);
    }

    public List<AutorizacionTerceros> getAllByRutEje(String rutEjecutivo) {
        return autorizacionTercerosRepository.getAllByRutEje(rutEjecutivo);
    }
    public AutorizacionTerceros getAutorizacionTercerosById(Long id) {
        return (this.autorizacionTercerosRepository.findById(id).orElse(null));
    }

    @Override
    public AutorizacionTerceros insert(AutorizacionTerceros autorizacionTerceros) {
        return this.autorizacionTercerosRepository.save(autorizacionTerceros);

    }
    @Override
    public AutorizacionTerceros updateAutorizacionTerceros(AutorizacionTerceros autorizacionTerceros) {
        return this.autorizacionTercerosRepository.save(autorizacionTerceros);
    }
    @Override
    public AutorizacionTerceros deleteAutorizacionTerceros(AutorizacionTerceros autorizacionTerceros) {
        return this.autorizacionTercerosRepository.save(autorizacionTerceros);
    }
    @Override
    public Long getIdByRutTerRutBen(String rutTercero, String rutBeneficiario) {
        return this.autorizacionTercerosRepository.getIdByRutTerRutBen(rutTercero, rutBeneficiario);
    }
}
