package mobalDev.model.utilisateur;

public enum RoleUtilisateurEnum {
	
	ROLE_ADMIN("adminstrateur"), //
	ROLE_DG("Directeur general"), //
	ROLE_COMMERCANT("commerçant"); //
	
	private String libelle;
	
	private RoleUtilisateurEnum(String libelle) {
		this.libelle = libelle;
	}

	public String getLabelle() {
		return libelle;
	}

}
