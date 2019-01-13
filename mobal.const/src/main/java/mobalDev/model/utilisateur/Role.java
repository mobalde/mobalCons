package mobalDev.model.utilisateur;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import mobalDev.model.AbstractEntity;

@Entity
@Table(name="role")
public class Role extends AbstractEntity{

	@Enumerated(EnumType.STRING)
	private RoleUtilisateurEnum role;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private Collection<User> user;
	
	protected Role() {
		super();
	}

	public RoleUtilisateurEnum getRole() {
		return role;
	}

	public void setRole(RoleUtilisateurEnum role) {
		this.role = role;
	}

	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}
}
