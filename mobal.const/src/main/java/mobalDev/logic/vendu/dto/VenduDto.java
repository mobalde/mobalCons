package mobalDev.logic.vendu.dto;

import java.time.LocalDate;

public class VenduDto {
	private LocalDate dateVente;
	private int quantite;
	private Double prixUnitaire;
	private double total;
	private Long idProduit;
	public LocalDate getdateVente() {
		return this.dateVente;
	}
	public void setdateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	
}
