package mobal.dev.test.VenduInBanque;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
	
	public void registration_test() {
		
		dto = new VenduInBanqueDto();
	}

}
