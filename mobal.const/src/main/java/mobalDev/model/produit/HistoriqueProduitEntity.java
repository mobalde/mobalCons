package mobalDev.model.produit;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import mobalDev.model.AbstractEntity;

@Entity
@Table(name="historique_produit")
public class HistoriqueProduitEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = -6158226607270502944L;
	
	@NotNull
	private String libelle;
	
	@NotNull
	private int quantite;
	
	@Enumerated(EnumType.STRING)
	@Column(name="marque", nullable=false)
	private MarqueProduitEnum type;
	
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
	public MarqueProduitEnum getType() {
		return type;
	}
	public void setType(MarqueProduitEnum type) {
		this.type = type;
	}
}
