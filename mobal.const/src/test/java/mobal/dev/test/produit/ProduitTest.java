package mobal.dev.test.produit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.produit.dto.MarqueProduitEnum;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.model.produit.LibelleProduitEnum;
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
		dto.setQuantiteCommande(1000);
		boolean result_1 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit avec type
		dto = new ProduitDto();
		dto.setLibelle("basket ball");
		dto.setLibelleEnum(LibelleProduitEnum.BASKET_BALL);
		dto.setQuantiteCommande(400);
		dto.setType(MarqueProduitEnum.AUTRE);
		boolean result_2 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit avec typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(1000);
		dto.setType(MarqueProduitEnum.GI_32_5);
		boolean result_3 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit avec typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(1000);
		dto.setType(MarqueProduitEnum.DIAMOND_32_5);
		boolean result_4 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit sans typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(700);
		dto.setType(MarqueProduitEnum.GI_42_5);
		boolean result_5 = this.produitController.produitAdd(session, dto);
		
		// Ajout produit avec typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setLibelleEnum(LibelleProduitEnum.CIMENT);
		dto.setQuantiteCommande(1000);
		dto.setType(MarqueProduitEnum.DIAMOND_42_5);
		boolean result_6 = this.produitController.produitAdd(session, dto);
		
		assertFalse(result_1);
		assertFalse(result_5);
		
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
		List<ProduitDto> dto = this.produitController.getProduit("ciment");
		ProduitDto Proddto = this.produitController.getProduitWithType(MarqueProduitEnum.GI_32_5);
		
		assertNotNull(dto);
		assertNotNull(Proddto);
		assertTrue(dto.get(0).getQuantiteCommande() > 0);
		
	}
}
