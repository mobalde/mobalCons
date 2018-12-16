package mobal.dev.test.VenduInBanque;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import mobal.dev.test.config.LibelleProduit;
import mobalDev.MobalConstApplication;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;
import mobalDev.resources.venduInBanque.venduInBanqueController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MobalConstApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class VenduInBanqueTest {
	
	@Inject
	private venduInBanqueController venduInController;
	
	@Inject
	HttpSession session;
	
	VenduInBanqueDto dto;
	
	List<VenduInBanqueDto> list = new ArrayList<>();
	
	@Test
	public void getListeVenteNonComptabilise_test() {
		
		list = this.venduInController.getListeVenteNonComptabilise(LibelleProduit.BASKET_BALL.getLibelle());
		
		assertNotNull(list);
		assertTrue(list.size() == 1);
		
	}

}
