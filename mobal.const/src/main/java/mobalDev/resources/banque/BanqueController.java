package mobalDev.resources.banque;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.General.AuthorisationUser;
import mobalDev.logic.banque.GestionBanque;
import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;

@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class BanqueController {

	@Inject
	private GestionBanque gestionBanque;
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/save/venteSemaine", method = RequestMethod.POST)
	public boolean registration(HttpSession session, @RequestBody VenduInBanqueDto dto){
		return this.gestionBanque.registration(dto);
	}
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/getsoldeanterieur/{id}", method = RequestMethod.GET)
	public Double getSoldeAnterieur(@PathVariable Long id){
		return this.gestionBanque.getSoldeAnterieur(id);
	}
}
