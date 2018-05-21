package mobalDev.logic.banque.dto;

import java.time.LocalDate;

public class BanqueDto {

	private LocalDate dateDepot;
	private String agenceDepot;
	private String numeroTicket;
	private Long Montant;
	private boolean isDepot;
	private boolean isRetrait;
	
	// private VenduEntity vendu;
	
	public LocalDate getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(LocalDate dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getAgenceDepot() {
		return agenceDepot;
	}
	public void setAgenceDepot(String agenceDepot) {
		this.agenceDepot = agenceDepot;
	}
	public String getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	public Long getMontant() {
		return Montant;
	}
	public void setMontant(Long montant) {
		Montant = montant;
	}
	public boolean isDepot() {
		return isDepot;
	}
	public void setDepot(boolean isDepot) {
		this.isDepot = isDepot;
	}
	public boolean isRetrait() {
		return isRetrait;
	}
	public void setRetrait(boolean isRetrait) {
		this.isRetrait = isRetrait;
	}
	
}
