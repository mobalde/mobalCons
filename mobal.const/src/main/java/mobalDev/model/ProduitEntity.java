package mobalDev.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class ProduitEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -4253299806522162158L;
	
	@Column(nullable = false)
	private String libelle;
	
	@OneToMany(mappedBy = "produit")
	private Set<VenduEntity> vendu;
	
	protected ProduitEntity() {
		super();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
