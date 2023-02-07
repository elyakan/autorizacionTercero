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

}
