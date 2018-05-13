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
@Table(name="prix")
public class PrixEntity extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = -144970633866307924L;
	
	@Column(nullable=false)
	private double prix;
	
	@OneToMany(mappedBy = "prix")
	private Set<VenduEntity> vendu;
	
	protected PrixEntity() {
		super();
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
