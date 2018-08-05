package mobalDev.logic.marchandise.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.logic.marchandise.mapper.MarchandisMapper;
import mobalDev.model.MarchandiseEntity;
import mobalDev.model.ProduitEntity;
import mobalDev.repo.marchadiseRepo.MarchandiseRepository;
import mobalDev.repo.produitRepo.ProduitRepository;

@Component
public class MarchandiseImpl implements GestionMarchandise{
	
	@Autowired
	MarchandiseRepository marchandiseRepo;
	
	@Inject
	private MarchandisMapper marchandiseMapper;
	
	@Inject
	private ProduitRepository produitRepo;

	@Override
	public boolean registration(MarchandiseDto dto) {
		Optional<ProduitEntity> produitEntity = this.produitRepo.findById(dto.getIdProduit());
		MarchandiseEntity marchandiseEntity = new MarchandiseEntity();
		marchandiseEntity = this.marchandiseMapper.convertDtoToEntity(dto);
		marchandiseEntity.setProduit(produitEntity.get());
		this.marchandiseRepo.saveAndFlush(marchandiseEntity);
		return true;
	}

	@Override
	public MarchandiseDto getLastMarchandise() {
		
		MarchandiseDto dto = new MarchandiseDto();
		MarchandiseEntity marchandiseEntity = this.marchandiseRepo.findLastMarchandise();
		if(marchandiseEntity != null){
			dto = this.marchandiseMapper.convertEntityToDto(marchandiseEntity);
		}
		return dto;
	}
	
	public int getNbSacAnterieur(){
		
		MarchandiseDto marchandiseDto = this.getLastMarchandise();
		return marchandiseDto.getNbSacAnterieur();
	}
}
