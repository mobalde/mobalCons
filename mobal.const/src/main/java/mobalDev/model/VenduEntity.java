package mobalDev.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendu")
public class VenduEntity  extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -4001045433013835005L;

	@Column(name="date_debut", nullable=false)
	private LocalDate dateDebut;
	@Column(name="date_fin", nullable=false)
	private LocalDate dateFin;
	@Column(nullable=false)
	private int quantite;
	private double total;
	
	// -- optional = true: l'attribut peut etre null
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="produit_id", referencedColumnName="id")
	private ProduitEntity produit;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="prix_id", referencedColumnName="id")
	private PrixEntity prix;
	
	@OneToOne(mappedBy = "vendu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private BanqueEntity banque;
	
	protected VenduEntity() {
		super();
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
