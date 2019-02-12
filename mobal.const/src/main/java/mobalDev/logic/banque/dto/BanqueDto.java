package mobalDev.logic.banque.dto;

import java.time.LocalDate;

public class BanqueDto {

	private Long id;
	private LocalDate dateOperation;
	private String agence;
	private String numeroTicket;
	private Double somme;
	private Double total;
	private boolean depot;
	private boolean retrait;
	private Double soldeAnterieur;
	
	public LocalDate getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(LocalDate dateDepot) {
		this.dateOperation = dateDepot;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agenceDepot) {
		this.agence = agenceDepot;
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
	public Double getArgent() {
		return somme;
	}
	public void setArgent(Double argentDepose) {
		this.somme = argentDepose;
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
