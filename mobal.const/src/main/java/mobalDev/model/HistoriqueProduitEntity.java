package mobalDev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="historique_produit")
public class HistoriqueProduitEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -6158226607270502944L;
	
	@NotNull
	private String libelle;
	
	@NotNull
	private int quantite;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
