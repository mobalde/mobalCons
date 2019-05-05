package mobalDev.General.Erreurs;

public class AuthentificationNotException extends Exception{
	
	public AuthentificationNotException(){
		super();
	}
	
	public AuthentificationNotException(String message){
		super(message);
	}
	
	public AuthentificationNotException(String message, Throwable cause){
		super(message, cause);
	}
	
	public AuthentificationNotException(Throwable cause){
		super(cause);
	}

}
