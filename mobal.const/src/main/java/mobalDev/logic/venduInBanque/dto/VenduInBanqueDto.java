package mobalDev.logic.venduInBanque.dto;

import java.time.LocalDate;
import java.util.List;

import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.vendu.dto.VenduDto;

public class VenduInBanqueDto {

	Long id;
	private boolean isDepotBanque;
	private LocalDate debutSemaine;
	private LocalDate finSemaine;
	
	private BanqueDto banqueDto;
	private List<VenduDto> venduDto;
	
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
	public BanqueDto getBanqueDto() {
		return banqueDto;
	}
	public void setBanqueDto(BanqueDto banqueDto) {
		this.banqueDto = banqueDto;
	}
	public List<VenduDto> getVenduDto() {
		return venduDto;
	}
	public void setVenduDto(List<VenduDto> venduDto) {
		this.venduDto = venduDto;
	}
	
}
