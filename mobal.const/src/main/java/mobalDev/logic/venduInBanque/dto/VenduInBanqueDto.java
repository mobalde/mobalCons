package mobalDev.logic.venduInBanque.dto;

import java.time.LocalDate;
import java.util.List;

import mobalDev.model.BanqueEntity;
import mobalDev.model.VenduEntity;

public class VenduInBanqueDto {

	Long id;
	private boolean isDepotBanque;
	private LocalDate debutSemaine;
	private LocalDate finSemaine;
	
	private BanqueEntity banque;
	private List<VenduEntity> venduEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDepotBanque() {
		return isDepotBanque;
	}
	public void setDepotBanque(boolean isDepotBanque) {
		this.isDepotBanque = isDepotBanque;
	}
	public LocalDate getDebutSemaine() {
		return debutSemaine;
	}
	public void setDebutSemaine(LocalDate debutSemaine) {
		this.debutSemaine = debutSemaine;
	}
	public LocalDate getFinSemaine() {
		return finSemaine;
	}
	public void setFinSemaine(LocalDate finSemaine) {
		this.finSemaine = finSemaine;
	}
	public BanqueEntity getBanque() {
		return banque;
	}
	public void setBanque(BanqueEntity banque) {
		this.banque = banque;
	}
	public List<VenduEntity> getVenduEntity() {
		return venduEntity;
	}
	public void setVenduEntity(List<VenduEntity> venduEntity) {
		this.venduEntity = venduEntity;
	}
}
