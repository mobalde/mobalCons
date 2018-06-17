package mobalDev.resources.utilisateur;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import mobalDev.logic.utilisateur.GestionUtilisateur;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;

/**
 * 
 * @author balde
 * cette class implemente les web services qui gèrent les utilisateurs
 *
 */
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping(path="/mobalc",
	consumes = MediaType.APPLICATION_JSON_VALUE, 
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class UtilisateurController{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Inject
	GestionUtilisateur gestionUtilisateur;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public UtilisateurDto connexion(@RequestBody UtilisateurDao utilisateurDao){
		Authentication auth = this.authenticate(utilisateurDao);
		return gestionUtilisateur.authentification(utilisateurDao,auth);
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public UtilisateurDto register(@RequestBody UtilisateurDao utilisateurDao){
		utilisateurDao.setPassword(bCryptPasswordEncoder.encode(utilisateurDao.getPassword()));
		return gestionUtilisateur.registration(utilisateurDao);
	}
	
	public Authentication authenticate(UtilisateurDao utilisateurDao) throws AuthenticationServiceException{
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(utilisateurDao.getEmail(),utilisateurDao.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
