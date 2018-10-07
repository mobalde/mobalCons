package mobalDev.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="banque")
public class BanqueEntity  extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1455722610428547992L;
	
	@Column(name="date_depot", nullable=false)
	private LocalDate dateDepot;
	@Column(name="agence_de_depot")
	private String agenceDepot;
	@Column(name="numero_ticket", nullable=false)
	private String numeroTicket;
	@Column(name="argent_depose", nullable=false)
	private Double argentDepose;
	@Column(name="solde_anterieur", nullable=false)
	private Double soldeAnterieur;
	@Column(name="total", nullable=false)
	private Double total;
	@Column(name="is_depot")
	private boolean isDepot;
	@Column(name="is_retrait")
	private boolean isRetrait;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	@JoinColumn(name="vendu_in_banque_id", referencedColumnName="id")
	private VenduInBanqueEntity venduInBanque;
	
	protected BanqueEntity() {
		super();
	}

	public LocalDate getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(LocalDate dateDepot) {
		this.dateDepot = dateDepot;
	}

	public String getAgenceDepot() {
		return agenceDepot;
	}

	public void setAgenceDepot(String agenceDepot) {
		this.agenceDepot = agenceDepot;
	}

	public String getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(String numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public Double getArgentDepose() {
		return argentDepose;
	}

	public void setArgentDepose(Double argentDepose) {
		this.argentDepose = argentDepose;
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
	
}
