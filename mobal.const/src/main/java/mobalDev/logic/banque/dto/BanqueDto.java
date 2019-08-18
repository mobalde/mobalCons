package mobalDev.logic.banque.dto;

import java.time.LocalDate;

import mobalDev.model.banque.MotifEnum;

public class BanqueDto {

	private Long id;
	private LocalDate dateOperation;
	private String agence;
	private String numeroTicket;
	private Double somme;
	private Double total;
	private boolean isDepot;
	private boolean isRetrait;
	private boolean isVirement;
	private Double soldeAnterieur;
	private MotifEnum motif;
	
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
	public void setSomme(Double argentDepose) {
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
	public Double getSomme() {
		return somme;
	}
	public MotifEnum getMotif() {
		return motif;
	}
	public void setMotif(MotifEnum motif) {
		this.motif = motif;
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
	public boolean isVirement() {
		return isVirement;
	}
	public void setVirement(boolean isVirement) {
		this.isVirement = isVirement;
	}
}
