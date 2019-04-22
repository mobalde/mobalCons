package mobalDev.model.produit;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mobalDev.model.AbstractEntity;
import mobalDev.model.commande.CommandeEntity;
import mobalDev.model.marchandise.MarchandiseEntity;
import mobalDev.model.vendu.VenduEntity;

@Entity
@Table(name="produit")
public class ProduitEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -4253299806522162158L;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(name = "quantite_commande", nullable = false)
	private int quantiteCommande;
	
	@Enumerated(EnumType.STRING)
	@Column(name="marque", nullable = false)
	private MarqueProduitEnum type;
	
	@OneToMany(mappedBy = "produit")
	private Set<VenduEntity> vendu;
	
	@OneToMany(mappedBy = "produit")
	private Set<MarchandiseEntity> marchandise;
	
	@Enumerated(EnumType.STRING)
	@Column(name="libelle_enum", nullable=false)
	private LibelleProduitEnum libelleEnum;
	
	public ProduitEntity() {
		super();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<VenduEntity> getVendu() {
		return vendu;
	}

	public void setVendu(Set<VenduEntity> vendu) {
		this.vendu = vendu;
	}

	public Set<MarchandiseEntity> getMarchandise() {
		return marchandise;
	}

	public void setMarchandise(Set<MarchandiseEntity> marchandise) {
		this.marchandise = marchandise;
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
	
}
