package mobal.dev.test.produit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.produit.MarqueProduitEnum;
import mobalDev.resources.produit.ProduitController;

public class ProduitTest extends ConfigTest{
	
	@Inject
	private ProduitController produitController;
	
	@Autowired
   	HttpSession session;
	
	private List<ProduitDto> list = new ArrayList<>();
	
	private ProduitDto dto;
	
	@Test
	public void addProduit_test() {
		
		// Ajout produit sans typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(1000); // pour la commande
		dto.setDateAchat(LocalDate.now()); // pour la commande
		dto.setMontant(13300000.0); // pour la commande
		dto.setType(MarqueProduitEnum.GI_32_5);
		boolean result_1 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit sans typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(700);
		dto.setDateAchat(LocalDate.now()); // pour la commande
		dto.setMontant(6900000.0); // pour la commande
		dto.setType(MarqueProduitEnum.GI_42_5);
		boolean result_5 = this.produitController.produitAdd(session, dto);
		
		assertTrue(result_1);
		assertTrue(result_5);
	}
	
	@Test
	public void getProduitAll_test() {
		
		this.list = this.produitController.getProduitAll(session);
		String libelle = this.list.stream()
							 .filter(x -> x.getLibelle().equals("ciment"))
							 .map(x->x.getLibelle())
							 .findFirst()
							 .orElse(null);
		assertNotNull(this.list);
		assertTrue(this.list.size() <= 6);
		assertTrue(libelle.equals("ciment"));
		
	}
	
	@Test
	public void otherFunctionProduit_test() {
		
		@SuppressWarnings("unused")
		int quantite = this.produitController.getQuantiteCommande("ciment");
		List<ProduitDto> listProdDto = this.produitController.getProduit("ciment");
		ProduitDto ProdDto = this.produitController.getProduitWithType(MarqueProduitEnum.GI_32_5);
		
		assertNotNull(listProdDto);
		assertNotNull(ProdDto);
		assertTrue(listProdDto.get(0).getQuantiteCommande() > 0);
		
	}
}
