package mobal.dev.test.banque;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import mobal.dev.test.config.ConfigTest;
import mobal.dev.test.config.LibelleProduitEnum;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.resources.banque.BanqueController;
import mobalDev.resources.venduInBanque.VenduInBanqueController;

public class BanqueTest extends ConfigTest{

	@Inject
	private BanqueController banqueController;
	
	@Inject 
	private VenduInBanqueController venduInController;
	
	@Inject
	private HttpSession session;
	
	List<VenduInBanqueDto> list = new ArrayList<>();
	
	private BanqueDto dto = new BanqueDto();
	
	@Test
	public void registration_test() {
		
		boolean result = false;
		list = this.venduInController.getListeVenteNonComptabilise(LibelleProduitEnum.BASKET_BALL.getLibelle());
		if(!list.isEmpty() && list != null) {
			list.get(0).setDepotBanque(true);
			setBanqueDto(dto, list.get(0));
			result = this.banqueController.registration(session, list.get(0));
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
		
		assertTrue(result);
	}
	
	private void setBanqueDto(BanqueDto dto, VenduInBanqueDto venduInBaDto) {
		dto.setAgenceDepot("Ecobank Kipé");
		dto.setArgentDepose(14725.0);
		dto.setDateDepot(LocalDate.now());
		dto.setNumeroTicket("1234727A");
		dto.setSoldeAnterieur(0.0);
		dto.setTotal(14725.0);
		venduInBaDto.setBanqueDto(dto);
	}
	
}
