package mobalDev.resources.marchandise;

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
import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class MarchandiseController {

	@Inject
	private GestionMarchandise gestionMarvhandise;
	
	@PreAuthorize(AuthorisationUser.ROLE_ADMIN_OR_DG)
	@RequestMapping(path = "/ajout/marchandise", method = RequestMethod.POST)
	private void marchandiseAdd(HttpSession session, @RequestBody MarchandiseDto dto){
		this.gestionMarvhandise.registration(dto);
	}
}
