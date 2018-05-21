package mobalDev.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="utilisateur")
public class User extends AbstractEntity {

	@NotNull
	private String Nom;
	@NotNull
    private String prenom;
	@NotNull
	@Column(unique=true)
    private String email;
	@NotNull
    private String password;
    private boolean enabled;
    
    @ManyToMany(fetch=FetchType.LAZY)
    private Collection<Role> roles;
    
    public User() {
    	super();
    }

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<Role> getRole() {
		return roles;
	}

	public void setRole(Collection<Role> role) {
		this.roles = role;
	}
}
