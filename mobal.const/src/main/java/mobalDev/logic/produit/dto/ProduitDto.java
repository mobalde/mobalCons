package mobalDev.logic.produit.dto;

import java.time.LocalDate;

import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.produit.MarqueProduitEnum;

public class ProduitDto {

	private Long id;
	
	private String libelle;
	
	private int quantiteCommande;
	
	private MarqueProduitEnum type;
	
	private LibelleProduitEnum libelleEnum;
	
	private Double montant;
	
	private LocalDate dateAchat;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public int getQuantiteCommande() {
		return quantiteCommande;
	}
	
	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}
	
	public MarqueProduitEnum getType() {
		return type;
	}
	
	public void setType(MarqueProduitEnum type) {
		this.type = type;
	}
	
	public LibelleProduitEnum getLibelleEnum() {
		return libelleEnum;
	}
	
	public void setLibelleEnum(LibelleProduitEnum libelleEnum) {
		this.libelleEnum = libelleEnum;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}
}
