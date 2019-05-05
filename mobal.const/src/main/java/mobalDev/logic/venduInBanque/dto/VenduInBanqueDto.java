package mobalDev.logic.venduInBanque.dto;

import java.time.LocalDate;
import java.util.List;

import mobalDev.logic.banque.dto.BanqueDto;
import mobalDev.logic.vendu.dto.VenduDto;

public class VenduInBanqueDto {

	Long id;
	private LocalDate debutSemaine;
	private LocalDate finSemaine;
	
	private BanqueDto banqueDto;
	private List<VenduDto> venduDto;
	
	private Double totalVente;
	
	private boolean depotBanque;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getTotalVente() {
		return totalVente;
	}
	public void setTotalVente(Double totalVente) {
		this.totalVente = totalVente;
	}
	public boolean isDepotBanque() {
		return depotBanque;
	}
	public void setDepotBanque(boolean depotBanque) {
		this.depotBanque = depotBanque;
	}
}
