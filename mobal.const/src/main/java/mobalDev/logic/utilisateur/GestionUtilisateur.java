package mobalDev.logic.utilisateur;

import javax.inject.Named;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;

public interface GestionUtilisateur {

	public UtilisateurDto authentification(UtilisateurDao utlisateurDao, Authentication auth);
	public UtilisateurDto registration(UtilisateurDao utlisateurDao);
	
}
