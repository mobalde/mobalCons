package mobalDev.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="marchandise")
public class MarchandiseEntity extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 3207648726924271591L;
	
	@Column(name="date_debut", nullable=false)
	private LocalDate dateDebut;
	@Column(name="date_fin")
	private LocalDate dateFin;
	@Column(name="nb_sac_vendu" , nullable=false)
	private int nbSacVendu;
	@Column(name="nb_sac_anterieur" , nullable=false)
	private int nbSacAnterieur;
	@Column(name="total_sac_vendu" , nullable=false)
	private int totalSacVendu;
	@Column(name="total_sac_marchandise", nullable=false)
	private int totalSacMarchandise;
	@Column(name="total_sac_restant")
	private int totalSacRestant;
	
	protected MarchandiseEntity() {
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

	public int getNbSacVendu() {
		return nbSacVendu;
	}

	public void setNbSacVendu(int nbSacVendu) {
		this.nbSacVendu = nbSacVendu;
	}

	public int getNbSacAnterieur() {
		return nbSacAnterieur;
	}

	public void setNbSacAnterieur(int nbSacAnterieur) {
		this.nbSacAnterieur = nbSacAnterieur;
	}

	public int getTotalSacVendu() {
		return totalSacVendu;
	}

	public void setTotalSacVendu(int totalSacVendu) {
		this.totalSacVendu = totalSacVendu;
	}

	public int getTotalSacMarchandise() {
		return totalSacMarchandise;
	}

	public void setTotalSacMarchandise(int totalSacMarchandise) {
		this.totalSacMarchandise = totalSacMarchandise;
	}

	public int getTotalSacRestant() {
		return totalSacRestant;
	}

	public void setTotalSacRestant(int totalSacRestant) {
		this.totalSacRestant = totalSacRestant;
	}
}