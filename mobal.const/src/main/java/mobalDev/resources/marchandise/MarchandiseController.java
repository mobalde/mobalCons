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
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/ajout/marchandise", method = RequestMethod.POST)
	private boolean marchandiseAdd(HttpSession session, @RequestBody MarchandiseDto dto){
		return this.gestionMarvhandise.registration(dto);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/searchOne", method = RequestMethod.GET)
	private MarchandiseDto getLastMarchandise(){
		
		return this.gestionMarvhandise.getLastMarchandise();
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/sacAnterieur", method = RequestMethod.GET)
	private int getNbSacAnterieur(){
		
		return this.gestionMarvhandise.getNbSacAnterieur();
	}
}
