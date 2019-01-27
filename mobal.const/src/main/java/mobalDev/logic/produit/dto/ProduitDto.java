package mobalDev.logic.produit.dto;

import mobalDev.model.produit.LibelleProduitEnum;
import mobalDev.model.produit.TailleProduitEnum;

public class ProduitDto {

	private Long id;
	private String libelle;
	private int quantiteCommande;
	private MarqueProduitEnum type;
	private LibelleProduitEnum libelleEnum;
	private TailleProduitEnum tailleProduitEnum;
	private String taille;
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
	public TailleProduitEnum getTailleProduitEnum() {
		return tailleProduitEnum;
	}
	public void setTailleProduitEnum(TailleProduitEnum tailleProduitEnum) {
		this.tailleProduitEnum = tailleProduitEnum;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
}
