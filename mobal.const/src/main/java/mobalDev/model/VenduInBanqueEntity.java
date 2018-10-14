package mobalDev.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendu_in_banque")
public class VenduInBanqueEntity extends AbstractEntity implements Serializable{
	
	@Column(name="is_depot_banque", nullable=false)
	private boolean isDepotBanque;
	
	@Column(name="debut_semaine", nullable=false)
	private LocalDate debutSemaine;
	
	@Column(name="fin_semaine", nullable=false)
	private LocalDate finSemaine;
	
	@OneToOne(mappedBy = "venduInBanque")
	private BanqueEntity banque;
	
	@OneToMany(mappedBy = "venduInBanque", fetch=FetchType.LAZY)
	private Set<VenduEntity> venduEntity;
	
	public VenduInBanqueEntity(){
		super();
	}

	public boolean isDepotBanque() {
		return isDepotBanque;
	}

	public void setDepotBanque(boolean isDepotBanque) {
		this.isDepotBanque = isDepotBanque;
	}

	public BanqueEntity getBanque() {
		return banque;
	}

	public void setBanque(BanqueEntity banque) {
		this.banque = banque;
	}

	public Set<VenduEntity> getVenduEntity() {
		return venduEntity;
	}

	public void setVenduEntity(Set<VenduEntity> venduEntity) {
		this.venduEntity = venduEntity;
	}

	public LocalDate getDebutSemaine() {
		return debutSemaine;
	}

	public void setDebutSemaine(LocalDate debutSemaine) {
		this.debutSemaine = debutSemaine;
	}

	public LocalDate getFinSemaine() {
		return finSemaine;
	}

	public void setFinSemaine(LocalDate finSemaine) {
		this.finSemaine = finSemaine;
	}
}
