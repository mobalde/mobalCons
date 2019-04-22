package mobalDev.resources.marchandise;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.General.AuthorisationUser;
import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;

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
	public MarchandiseDto marchandiseAdd(HttpSession session, @RequestBody MarchandiseDto dto){
		return this.gestionMarvhandise.registration(dto);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/searchOne", method = RequestMethod.GET)
	public MarchandiseDto getLastMarchandise(){
		return this.gestionMarvhandise.getLastMarchandise();
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@GetMapping(path = "/nombreSacVendu/{idProduit}")
	public MarchandiseDto nombreDeSacVendu(@PathVariable Long idProduit) {
		MarchandiseDto dto = new MarchandiseDto();
		this.gestionMarvhandise.nombreDeSacVendu(dto, idProduit);
		return dto;
	}
}
