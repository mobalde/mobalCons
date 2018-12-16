package mobal.dev.test.produit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import mobalDev.MobalConstApplication;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.dto.TypeProduitEnum;
import mobalDev.resources.produit.ProduitController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MobalConstApplication.class})
@TestPropertySource("classpath:application-test.properties")
@WebAppConfiguration
public class ProduitTest {
	
	@Inject
	private ProduitController produitCintroller;
	
	@Autowired
   	HttpSession session;
	
	private List<ProduitDto> list = new ArrayList<>();
	
	private ProduitDto dto;
	
	@Test
	public void addProduit_test() {
		
		// Ajout produit sans typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setQuantiteCommande(1000);
		boolean result_1 = this.produitCintroller.produitAdd(session, dto);
		
		// Ajout produit avec type
		dto = new ProduitDto();
		dto.setLibelle("basket ball");
		dto.setQuantiteCommande(400);
		dto.setType(TypeProduitEnum.AUTRE);
		boolean result_2 = this.produitCintroller.produitAdd(session, dto);
		
		// Ajout produit avec typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setQuantiteCommande(1000);
		dto.setType(TypeProduitEnum.GI);
		boolean result_3 = this.produitCintroller.produitAdd(session, dto);
		
		// Ajout produit avec typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setQuantiteCommande(1000);
		dto.setType(TypeProduitEnum.GI);
		boolean result_4 = this.produitCintroller.produitAdd(session, dto);
		
		// Ajout produit sans typeProduit
		dto = new ProduitDto();
		dto.setLibelle("ciment");
		dto.setQuantiteCommande(700);
		dto.setType(TypeProduitEnum.GI);
		boolean result_5 = this.produitCintroller.produitAdd(session, dto);
		
		assertFalse(result_1);
		assertFalse(result_2);
		assertTrue(result_3);
		assertFalse(result_4);
		assertTrue(result_5);
		
	}
	
	@Test
	public void getProduitAll_test() {
		
		this.list = this.produitCintroller.getProduitAll(session);
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
		
		int quantite = this.produitCintroller.getQuantiteCommande("ciment");
		List<ProduitDto> dto = this.produitCintroller.getProduit("ciment");
		
		assertNotNull(dto);
		assertTrue(dto.get(0).getQuantiteCommande() > 0);
		
	}
}
