package mobalDev.logic.marchandise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mobalDev.logic.marchandise.GestionMarchandise;
import mobalDev.logic.marchandise.dto.MarchandiseDto;
import mobalDev.model.MarchandiseEntity;
import mobalDev.repo.marchadiseRepo.MarchandiseRepository;

@Component
public class MarchandiseImpl implements GestionMarchandise{
	
	@Autowired
	MarchandiseRepository marchandiseRepo;

	@Override
	public void registration(MarchandiseDto dto) {
		MarchandiseEntity marchandiseEntity = new MarchandiseEntity();
		marchandiseEntity.setDateDebut(dto.getDateDebut());
		marchandiseEntity.setDateFin(dto.getDateFin());
		marchandiseEntity.setNbSacAnterieur(dto.getNbSacAnterieur());
		marchandiseEntity.setNbSacVendu(dto.getNbSacVendu());
		marchandiseEntity.setTotalSacMarchandise(dto.getTotalSacMarchandise());
		marchandiseEntity.setTotalSacRestant(dto.getTotalSacRestant());
		marchandiseEntity.setTotalSacVendu(dto.getTotalSacVendu());
		
		this.marchandiseRepo.saveAndFlush(marchandiseEntity);
	}
	
	

}
