package mobalDev.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendu_in_banque")
public class VenduInBanqueEntity extends AbstractEntity{

	@Column(name="is_depot_banque")
	private boolean isDepotBanque;
	
	@OneToOne(mappedBy = "venduInBanque")
	private BanqueEntity banque;
	
	@OneToMany(mappedBy = "venduInBanque")
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
}
