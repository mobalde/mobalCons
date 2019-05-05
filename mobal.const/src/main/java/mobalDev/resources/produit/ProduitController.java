package mobalDev.resources.produit;

import java.util.List;

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
import mobalDev.logic.produit.GestionProduit;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.model.produit.MarqueProduitEnum;

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
	public boolean produitAdd(HttpSession session, @RequestBody ProduitDto dto){
		return this.gestionProduit.registration(dto);
	}
	
	
	@PreAuthorize(AuthorisationUser.PDG)
	@RequestMapping(path = "/produit/all", method = RequestMethod.GET)
	public List<ProduitDto> getProduitAll(HttpSession session){
		return this.gestionProduit.getAllProduit();
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/quanitite/{libelle}", method = RequestMethod.GET)
	public int getQuantiteCommande(@PathVariable("libelle") String libelle){
		return this.gestionProduit.getQuantiteCommande(libelle);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/{libelle}", method = RequestMethod.GET)
	public List<ProduitDto> getProduit(@PathVariable("libelle") String libelle){
		return this.gestionProduit.getProduit(libelle);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/type/{type}", method = RequestMethod.GET)
	public ProduitDto getProduitWithType(@PathVariable MarqueProduitEnum type){
		return this.gestionProduit.getProduit(type);
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/libelle", method = RequestMethod.GET)
	public List<String> getLibelleAll(){
		return this.gestionProduit.getLibelleAll();
	}
	
	@PreAuthorize(AuthorisationUser.PDG_OR_DG)
	@RequestMapping(path = "/produit/marque", method = RequestMethod.GET)
	public List<String> getMarqueAll(){
		return this.gestionProduit.getMarqueAll();
	}

}
