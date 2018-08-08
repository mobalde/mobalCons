package mobalDev.resources.produit;

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
import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.produit.GestionProduit;
import mobalDev.logic.produit.dto.ProduitDto;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProduitController {
	
	@Inject
	private GestionProduit gestionProduit;
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/ajout/produit", method = RequestMethod.POST)
	public void produitAdd(HttpSession session, @RequestBody ProduitDto dto){
		this.gestionProduit.registration(dto);
	}
	
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/quanitite/{libelle}", method = RequestMethod.GET)
	public int getQuantiteCommande(@PathVariable("libelle") String libelle){
		return this.gestionProduit.getQuantiteCommande(libelle);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/{libelle}", method = RequestMethod.GET)
	public ProduitDto getProduit(@PathVariable("libelle") String libelle){
		return this.gestionProduit.getProduit(libelle);
	}

}