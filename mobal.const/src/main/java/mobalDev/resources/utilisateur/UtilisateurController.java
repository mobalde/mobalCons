package mobalDev.resources.utilisateur;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import mobalDev.General.LoggerInfo;
import mobalDev.logic.utilisateur.GestionUtilisateur;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;

/**
 * 
 * @author balde
 * cette class implemente les web services qui gèrent les utilisateurs
 *
 */

@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class UtilisateurController extends LoggerInfo{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Inject
	GestionUtilisateur gestionUtilisateur;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public UtilisateurDto connexion(@RequestBody UtilisateurDao utilisateurDao){
		Authentication auth = this.authenticate(utilisateurDao);
		return gestionUtilisateur.authentification(utilisateurDao,auth);
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public UtilisateurDto register(@RequestBody UtilisateurDao utilisateurDao){
		return gestionUtilisateur.registration(utilisateurDao);
	}
	
	public Authentication authenticate(UtilisateurDao utilisateurDao) throws AuthenticationServiceException{
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(utilisateurDao.getEmail(),utilisateurDao.getPasswrd());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
