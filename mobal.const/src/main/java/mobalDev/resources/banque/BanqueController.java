package mobalDev.resources.banque;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.dto.BanqueDto;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class BanqueController {

	@Inject
	private GestionBanque gestionBanque;
	
	@RequestMapping(path = "/add/banque", method = RequestMethod.POST)
	private void registration(HttpSession session, @RequestBody BanqueDto dto){
		this.gestionBanque.registration(dto);
	}
}
