package mobal.dev.test.VenduInBanque;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import mobal.dev.test.config.ConfigTest;
import mobal.dev.test.config.LibelleProduitEnum;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.resources.venduInBanque.VenduInBanqueController;

public class VenduInBanqueTest extends ConfigTest{
	
	@Inject
	private VenduInBanqueController venduInController;
	
	@Inject
	HttpSession session;
	
	VenduInBanqueDto dto;
	
	List<VenduInBanqueDto> list = new ArrayList<>();
	
	@Test
	public void getListeVenteNonComptabilise_test() {
		
		list = this.venduInController.getListeVenteNonComptabilise(LibelleProduitEnum.BASKET_BALL.getLibelle());
		
		assertNotNull(list);
		assertTrue(list.size() == 1);
		
	}

}
