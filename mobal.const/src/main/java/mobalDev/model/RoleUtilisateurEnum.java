package mobalDev.model;

public enum RoleUtilisateurEnum {
	
	ROLE_ADMIN("adminstrateur"), //
	ROLE_DG("Directeur general"), //
	ROLE_COMMERCANT("commerçant"); //
	
	private String labelle;
	
	private RoleUtilisateurEnum(String labelle) {
		this.labelle = labelle;
	}

	public String getLabelle() {
		return labelle;
	}

}
