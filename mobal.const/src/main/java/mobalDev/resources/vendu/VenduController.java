package mobalDev.resources.vendu;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.General.AuthorisationUser;
import mobalDev.logic.vendu.GestionVente;
import mobalDev.logic.vendu.dto.VenduDto;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class VenduController {
	
	@Inject
	private GestionVente gestionVente;
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public boolean saveVente(HttpSession session, @RequestBody List<VenduDto> listVente){
		return this.gestionVente.registration(listVente);
	}
}
