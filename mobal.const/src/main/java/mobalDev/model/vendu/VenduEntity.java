package mobalDev.model.vendu;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mobalDev.model.AbstractEntity;
import mobalDev.model.produit.ProduitEntity;
import mobalDev.model.venduInBanque.VenduInBanqueEntity;

@Entity
@Table(name="vendu")
public class VenduEntity  extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4001045433013835005L;

	@Column(name="date_vente", nullable=false)
	private LocalDate dateVente;
	
	@Column(nullable=false)
	private int quantite;
	
	@Column(name="prix_unitaire")
	private Double prixUnitaire;
	
	private double total;
	
	// -- optional = true: l'attribut peut etre null
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="produit_id", referencedColumnName="id")
	private ProduitEntity produit;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="vendu_in_banque_id", referencedColumnName="id")
	private VenduInBanqueEntity venduInBanque;
	
	@Column(name="is_comptabiliser")
	private boolean isComptabiliser = false;
	
	protected VenduEntity() {
		super();
	}

	public LocalDate getDateVente() {
		return this.dateVente;
	}

	public void setDateVente(LocalDate dateV) {
		this.dateVente = dateV;
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

	public ProduitEntity getProduit() {
		return produit;
	}

	public void setProduit(ProduitEntity produit) {
		this.produit = produit;
	}

	public VenduInBanqueEntity getVenduInBanque() {
		return venduInBanque;
	}

	public void setVenduInBanque(VenduInBanqueEntity venduInBanque) {
		this.venduInBanque = venduInBanque;
	}

	public boolean isComptabiliser() {
		return isComptabiliser;
	}

	public void setComptabiliser(boolean isComptabiliser) {
		this.isComptabiliser = isComptabiliser;
	}
}
