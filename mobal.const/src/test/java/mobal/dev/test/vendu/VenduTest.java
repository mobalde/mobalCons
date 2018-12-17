package mobal.dev.test.vendu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.resources.vendu.VenduController;

public class VenduTest extends ConfigTest{
	
	@Inject
	private HttpSession session;
	
	@Inject
	private VenduController venduController;
	
	VenduDto dto;
	
	List<VenduDto> listVente = new ArrayList<>();
	
	@Test
	public void registration_test() {
		
		LocalDate date1 = LocalDate.of(2018, Month.DECEMBER, 2);
		
		listVente.add(setVendu(date1, 2, 2345.0, 2345.0*2, 4L));
		listVente.add(setVendu(date1, 3, 3345.0, 3345.0*3, 4L));
		
		boolean isVente = this.venduController.saveVente(session, listVente);
		assertTrue(isVente);
		
		boolean isNotVente = this.venduController.saveVente(session, new ArrayList<>());
		assertFalse(isNotVente);
	}
	
	private VenduDto setVendu(LocalDate date1, int quantite, Double prixUnitaire, Double total, Long idProduit) {
		
		dto = new VenduDto();
		dto.setdateVente(date1);
		dto.setIdProduit(idProduit);
		dto.setPrixUnitaire(prixUnitaire);
		dto.setQuantite(quantite);
		dto.setTotal(total);
		
		return dto;
	}

}
