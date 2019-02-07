package mobalDev.model.banque;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mobalDev.model.AbstractEntity;
import mobalDev.model.venduInBanque.VenduInBanqueEntity;

@Entity
@Table(name="banque")
public class BanqueEntity  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1455722610428547992L;
	
	@Column(name="date_operation", nullable=false)
	private LocalDate dateOperation;
	@Column(name="agence")
	private String agence;
	@Column(name="numero_ticket", nullable=false)
	private String numeroTicket;
	@Column(name="somme", nullable=false)
	private Double somme;
	@Column(name="solde_anterieur", nullable=false)
	private Double soldeAnterieur;
	@Column(name="total", nullable=false)
	private Double total;
	@Column(name="is_depot")
	private boolean isDepot;
	@Column(name="is_retrait")
	private boolean isRetrait;
	@Column(name="is_virement")
	private boolean isVirement;
	private String motif;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="vendu_in_banque_id", referencedColumnName="id")
	private VenduInBanqueEntity venduInBanque;

	public LocalDate getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(LocalDate dateDepot) {
		this.dateOperation = dateDepot;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agenceDepot) {
		this.agence = agenceDepot;
	}

	public String getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public Double getSomme() {
		return somme;
	}

	public void setSomme(Double argentDepose) {
		this.somme = argentDepose;
	}

	public Double getSoldeAnterieur() {
		return soldeAnterieur;
	}

	public void setSoldeAnterieur(Double soldeAnterieur) {
		this.soldeAnterieur = soldeAnterieur;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public boolean isDepot() {
		return isDepot;
	}

	public void setDepot(boolean isDepot) {
		this.isDepot = isDepot;
	}

	public boolean isRetrait() {
		return isRetrait;
	}

	public void setRetrait(boolean isRetrait) {
		this.isRetrait = isRetrait;
	}

	public VenduInBanqueEntity getVenduInBanque() {
		return venduInBanque;
	}

	public void setVenduInBanque(VenduInBanqueEntity venduInBanque) {
		this.venduInBanque = venduInBanque;
	}

	public boolean isVirement() {
		return isVirement;
	}

	public void setVirement(boolean isVirement) {
		this.isVirement = isVirement;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
}
