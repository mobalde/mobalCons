package mobalDev.resources.utilisateur;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import mobalDev.logic.utilisateur.GestionUtilisateur;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.User;
import mobalDev.repo.utilisateurRepo.UtilisateurRepository;

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
	
	private static final String CURRENT_USER = "currentUser";
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Inject
	GestionUtilisateur gestionUtilisateur;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Inject
	private UtilisateurRepository utilisateurRepo;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public UtilisateurDto connexion(HttpSession session, @RequestBody UtilisateurDao utilisateurDao){
		User user = this.utilisateurRepo.findByEmail(utilisateurDao.getEmail());
		Authentication auth = this.authenticate(utilisateurDao);
		return gestionUtilisateur.authentification(user,auth, session);
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
	public UtilisateurDto register(@RequestBody UtilisateurDao utilisateurDao){
		utilisateurDao.setPassword(bCryptPasswordEncoder.encode(utilisateurDao.getPassword()));
		return gestionUtilisateur.registration(utilisateurDao);
	}
	
	public Authentication authenticate(UtilisateurDao utilisateurDao) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(utilisateurDao.getEmail(),utilisateurDao.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	@RequestMapping(path = "/currentUser/{email:.+}", method = RequestMethod.GET)
	public boolean isConnecter(HttpSession session, @PathVariable String email){
		if(session.getAttribute(CURRENT_USER) != null && session.getMaxInactiveInterval() == 1800){
			String mail = (String) session.getAttribute(CURRENT_USER);
			return (mail.equals(email));
		}
		return this.logoutPage(null, null, session);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public boolean logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && session.getAttribute(CURRENT_USER) != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        return true;
	    }
	    return false;
	}
}
