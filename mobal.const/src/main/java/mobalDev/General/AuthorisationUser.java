package mobalDev.General;

public class AuthorisationUser {
	
	public static final String PDG_OR_DG = "hasRole('ROLE_ADMIN') or hasRole('ROLE_DG')";
	public static final String PDG = "hasRole('ROLE_ADMIN')";

}
