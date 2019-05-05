package mobal.dev.test.vendu;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.logic.vendu.dto.VenduDto;
import mobalDev.model.produit.ProduitEntity;
import mobalDev.model.vendu.VenduEntity;
import mobalDev.repo.produitRepo.ProduitRepository;
import mobalDev.repo.venduRepo.VenduRepository;
import mobalDev.resources.vendu.VenduController;

public class VenduTest extends ConfigTest{
	
	@Inject
	private HttpSession session;
	
	@Inject
	private VenduController venduController;
	
	@Inject
	private ProduitRepository prodRepo;
	
	@Inject 
	private ProduitMapper prodMapper;
	
	@Inject
	private VenduRepository venduRepo;
	
	VenduDto dto;
	
	List<VenduDto> listVente = new ArrayList<>();
	
	@Test
	public void registration_test() {
		
		List<VenduEntity> venduEntity = this.venduRepo.findAll();
		if(venduEntity == null || venduEntity.isEmpty()) {
			LocalDate date1 = LocalDate.of(2018, Month.DECEMBER, 2);
			
			Optional<ProduitEntity> prodEntity = this.prodRepo.findById(2L);
			ProduitDto prodDto = this.prodMapper.convertEntityToDto(prodEntity.get());
			
			listVente.add(setVendu(date1, 2, 2345.0, 2345.0*2, prodDto));
			listVente.add(setVendu(date1, 3, 3345.0, 3345.0*3, prodDto));
			
			boolean isVente = this.venduController.saveVente(session, listVente);
			assertTrue(isVente);
			
			boolean isNotVente = this.venduController.saveVente(session, new ArrayList<>());
			assertFalse(isNotVente);
		}
		
	}
	
	private VenduDto setVendu(LocalDate date1, int quantite, Double prixUnitaire, Double total, ProduitDto prodDto) {
		
		dto = new VenduDto();
		dto.setDateVente(date1);
		dto.setProduit(prodDto);
		dto.setPrixUnitaire(prixUnitaire);
		dto.setQuantite(quantite);
		dto.setTotal(total);
		
		return dto;
	}

}
