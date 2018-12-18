package mobalDev.resources.venduInBanque;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.General.AuthorisationUser;
import mobalDev.logic.venduInBanque.GestionVenduInBanque;
import mobalDev.logic.venduInBanque.dto.VenduInBanqueDto;

@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class VenduInBanqueController {
	
	@Inject
	private GestionVenduInBanque gestionVenduInBanque;
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/all/notVenduInBanque/{libelleProduit}", method = RequestMethod.GET)
	public List<VenduInBanqueDto> getListeVenteNonComptabilise(@PathVariable("libelleProduit") String libelleProduit){
		
		return this.gestionVenduInBanque.listeDeVenteProduitNonDeposer(libelleProduit);
	}

}
