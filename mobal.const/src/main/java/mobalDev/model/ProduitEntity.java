package mobalDev.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mobalDev.logic.produit.dto.TypeProduitEnum;

@Entity
@Table(name="produit")
public class ProduitEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -4253299806522162158L;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(name = "quantite_commande", nullable = false)
	private int quantiteCommande;
	
	@Enumerated(EnumType.STRING)
	private TypeProduitEnum type;
	
	@OneToMany(mappedBy = "produit")
	private Set<VenduEntity> vendu;
	
	@OneToMany(mappedBy = "produit")
	private Set<MarchandiseEntity> marchandise;
	
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

	public TypeProduitEnum getType() {
		return type;
	}

	public void setType(TypeProduitEnum type) {
		this.type = type;
	}
	
}
