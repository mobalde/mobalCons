package mobalDev.logic.banque.dto;

import java.time.LocalDate;

public class BanqueDto {

	private Long id;
	private LocalDate dateDepot;
	private String agenceDepot;
	private String numeroTicket;
	private Double argentDepose;
	private Double total;
	private boolean depot;
	private boolean retrait;
	private Double soldeAnterieur;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getArgentDepose() {
		return argentDepose;
	}
	public void setArgentDepose(Double argentDepose) {
		this.argentDepose = argentDepose;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getSoldeAnterieur() {
		return soldeAnterieur;
	}
	public void setSoldeAnterieur(Double soldeAnterieur) {
		this.soldeAnterieur = soldeAnterieur;
	}
	public boolean isDepot() {
		return depot;
	}
	public void setDepot(boolean depot) {
		this.depot = depot;
	}
	public boolean isRetrait() {
		return retrait;
	}
	public void setRetrait(boolean retrait) {
		this.retrait = retrait;
	}
}
