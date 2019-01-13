package mobalDev.logic.utilisateur;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.utilisateur.User;

public interface GestionUtilisateur {

	public UtilisateurDto authentification(User user, Authentication auth, HttpSession session);
	public UtilisateurDto registration(UtilisateurDao utlisateurDao);
	
}
