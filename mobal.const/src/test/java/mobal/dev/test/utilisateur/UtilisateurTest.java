package mobal.dev.test.utilisateur;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import mobal.dev.test.config.DatabaseConfigTest;
import mobalDev.MobalConstApplication;
import mobalDev.logic.utilisateur.GestionUtilisateur;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.model.RoleUtilisateurEnum;
import mobalDev.repo.utilisateurRepo.UtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MobalConstApplication.class, DatabaseConfigTest.class})
@WebAppConfiguration
public class UtilisateurTest {
	
	@Resource
    private UtilisateurRepository utilisateurRepo;
	
	@Inject
	private GestionUtilisateur gestionUtilisateur;
     
    @Test
    public void givenStudent_whenSave_thenGetOk() {
    	
    	UtilisateurDao dao = new UtilisateurDao();
		dao.setEmail("mobal.const@test.fr");
		dao.setPassword("mobal");
		dao.setNom("CONST");
		dao.setPrenom("Mobal");
		dao.setRole(RoleUtilisateurEnum.ROLE_DG);
		UtilisateurDto utilisateurDto = this.gestionUtilisateur.registration(dao);
		
		assertNotNull(utilisateurDto);
		assertTrue(utilisateurDto.getEmail().equals(dao.getEmail()));
    }
    
}
