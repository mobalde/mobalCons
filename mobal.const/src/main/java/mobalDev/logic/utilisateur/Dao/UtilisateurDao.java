package mobalDev.logic.utilisateur.Dao;

import mobalDev.model.utilisateur.RoleUtilisateurEnum;

public class UtilisateurDao {

	private String email;
	private String password;
	private String nom;
	private String prenom;
	private RoleUtilisateurEnum role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passwrd) {
		this.password = passwrd;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public RoleUtilisateurEnum getRole() {
		return role;
	}
	public void setRole(RoleUtilisateurEnum role) {
		this.role = role;
	}
}
