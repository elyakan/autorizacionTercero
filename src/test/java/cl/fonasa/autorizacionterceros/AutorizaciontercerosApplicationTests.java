package cl.fonasa.autorizacionterceros;

import cl.fonasa.autorizacionterceros.model.AutorizacionTerceros;
import cl.fonasa.autorizacionterceros.services.AutorizacionTercerosService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AutorizaciontercerosApplicationTests {

	@Autowired

	AutorizacionTercerosService autorizacionTercerosService;
	@Test
	void testFindAll() {
		List<AutorizacionTerceros> autorizacionTercerosAll = autorizacionTercerosService.getAutorizacionTercerosAll();
		assertEquals(2, autorizacionTercerosAll.size());
	}

}
