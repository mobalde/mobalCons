package mobalDev.model.commande;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import mobalDev.model.AbstractEntity;
import mobalDev.model.banque.BanqueEntity;
import mobalDev.model.produit.ProduitEntity;

@Entity
@Table(name="commande")
public class CommandeEntity  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -7111904111199510077L;
	
	@NotNull
	private Double montant;
	
	@NotNull
	private int quantite;
	
	@Column(name="date_achat", nullable=false)
	private LocalDate dateAchat;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="produit_id", referencedColumnName="id")
	private ProduitEntity produit;

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public ProduitEntity getProduit() {
		return produit;
	}

	public void setProduit(ProduitEntity produit) {
		this.produit = produit;
	}
}
