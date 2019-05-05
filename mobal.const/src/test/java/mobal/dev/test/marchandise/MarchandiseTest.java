package mobal.dev.test.marchandise;

import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.logic.produit.dto.ProduitDto;
import mobalDev.logic.produit.mapper.ProduitMapper;
import mobalDev.model.produit.ProduitEntity;
import mobalDev.repo.produitRepo.ProduitRepository;
import mobalDev.resources.marchandise.MarchandiseController;

public class MarchandiseTest extends ConfigTest{

	@Inject
	private MarchandiseController marchandiseController;
	
	@Inject
	private HttpSession session;
	
	@Inject
	private ProduitMapper produitMapper;
	
	@Inject
	private ProduitRepository produitRepo;
	
	private MarchandiseDto dto = new MarchandiseDto();
	
	private ProduitEntity produitEntity;
	
	@Test
	public void registration_test() {
		
		Optional<ProduitEntity> entity = this.produitRepo.findById(2L);
		if(entity.isPresent()) {
			this.produitEntity = entity.get();
			ProduitDto produitDto = this.produitMapper.convertEntityToDto(produitEntity);
			dto = this.marchandiseController.nombreDeSacVendu(produitDto.getId());
			initMarchandise(dto, produitDto);
			this.marchandiseController.marchandiseAdd(session, dto);
		}
	}
	
	private void initMarchandise(MarchandiseDto dto, ProduitDto pDto) {
		dto.setTotalSacMarchandise(pDto.getQuantiteCommande());
		dto.setTotalSacVendu(dto.getNbSacVendu());
		dto.setTotalSacRestant(dto.getTotalSacMarchandise()-dto.getTotalSacVendu());
		dto.setProduitDto(pDto);
	}
}
