package mobal.dev.test.utilisateur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mobal.dev.test.config.ConfigTest;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.utilisateur.RoleUtilisateurEnum;
import mobalDev.resources.utilisateur.UtilisateurController;

public class UtilisateurTest extends ConfigTest{
	
   	@Inject
	private UtilisateurController utilisateurController;
   	
   	@Autowired
   	HttpSession session;
   	
   	@Autowired
   	private HttpServletRequest request;
   	
   	@Autowired
   	private HttpServletResponse response;
     
    @Test
    public void registration_user_test() {
    	
    	UtilisateurDao dao = new UtilisateurDao();
		dao.setEmail("mobal.consterner@test.fr");
		dao.setPassword("mobalcon");
		dao.setNom("CONST");
		dao.setPrenom("Mobal");
		dao.setRole(RoleUtilisateurEnum.ROLE_DG);
		
		UtilisateurDto utilisateurDto = this.utilisateurController.register(dao);
		
		assertNotNull(utilisateurDto);
		assertTrue(utilisateurDto.getNom().equals(dao.getNom()));
		
    }
    
   	@Test
    public void connexion_test() {
    	UtilisateurDao dao = new UtilisateurDao();
		dao.setEmail("mobal.consterner@test.fr");
		dao.setPassword("mobalcon");
		
		UtilisateurDto dto = this.utilisateurController.connexion(session, dao);
		assertNotNull(dto);
		assertTrue(dto.getEmail().equals(dao.getEmail()));
		
		boolean isconnecte = this.utilisateurController.isConnecter(session, dao.getEmail());
		assertTrue(isconnecte);
		
		boolean isNonconnecte = this.utilisateurController.isConnecter(session, "test@yahoo.fr");
		assertFalse(isNonconnecte);
		
		@SuppressWarnings("unused")
		boolean isDeconnexion = this.utilisateurController.logoutPage(request, response, session);
		assertTrue(isconnecte);
    }
    
}
