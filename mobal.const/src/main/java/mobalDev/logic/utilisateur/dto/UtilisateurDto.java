package mobalDev.logic.utilisateur.dto;

import java.util.List;

import mobalDev.model.RoleUtilisateurEnum;

public class UtilisateurDto {
	
	private String email;
	private String password;
	private String Nom;
	private String prenom;
	private List<RoleUtilisateurEnum> role;
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
	public List<RoleUtilisateurEnum> getRole() {
		return role;
	}
	public void setRole(List<RoleUtilisateurEnum> role) {
		this.role = role;
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
	
}
