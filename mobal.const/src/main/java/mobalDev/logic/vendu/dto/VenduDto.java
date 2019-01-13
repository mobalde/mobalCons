package mobalDev.logic.vendu.dto;

import java.time.LocalDate;

import mobalDev.logic.produit.dto.ProduitDto;

public class VenduDto {
	private LocalDate dateVente;
	private int quantite;
	private Double prixUnitaire;
	private Double total;
	private ProduitDto produit;
	
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
	public ProduitDto getProduit() {
		return produit;
	}
	public void setProduit(ProduitDto produit) {
		this.produit = produit;
	}
	public LocalDate getDateVente() {
		return dateVente;
	}
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
}
