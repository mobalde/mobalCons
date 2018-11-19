package mobalDev.logic.utilisateur.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import mobalDev.logic.utilisateur.GestionUtilisateur;
import mobalDev.logic.utilisateur.Dao.UtilisateurDao;
import mobalDev.logic.utilisateur.dto.UtilisateurDto;
import mobalDev.logic.utilisateur.mapper.UtilisateurMapper;
import mobalDev.model.Role;
import mobalDev.model.RoleUtilisateurEnum;
import mobalDev.model.User;
import mobalDev.repo.roleRepo.RoleRepository;
import mobalDev.repo.utilisateurRepo.UtilisateurRepository;

/**
 * 
 * @author balde
 *
 */
@Component
public class UtilisateurImpl implements GestionUtilisateur{
	
	private LocalTime now = LocalTime.now();
	
	@Inject
	private UtilisateurRepository utilisateurRepo;
	
	@Inject
	private RoleRepository roleRepository;
	
	@Inject
	UtilisateurMapper utilisateurMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	/**
	 * 
	 * @Param utilisateurDao et l'objet auth
	 * cette methode recupere les info de l'utilisateur lors de la connexion
	 * 
	 */
	@Override
	public UtilisateurDto authentification(User user, Authentication auth, HttpSession session) {
		
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		utilisateurDto.setEmail(user.getEmail());
		utilisateurDto.setPassword(null);
		utilisateurDto.setNom(user.getNom());
		utilisateurDto.setPrenom(user.getPrenom());
		List<RoleUtilisateurEnum> roles = new ArrayList<>();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		authorities.stream()
				.map(x -> x.getAuthority())
				.forEach(y -> {
					switch(y){
						case "ROLE_ADMIN":
							roles.add(RoleUtilisateurEnum.ROLE_ADMIN);
							break;
						case "ROLE_DG":
							roles.add(RoleUtilisateurEnum.ROLE_DG);
							break;
						case "ROLE_COMMERCANT":
							roles.add(RoleUtilisateurEnum.ROLE_COMMERCANT);
							break;
						default:
						break;
					}
				});
		utilisateurDto.setRole(roles);
		utilisateurDto.setResponses("Authenification reussie");
		session.setAttribute("currentUser", utilisateurDto.getEmail());
		session.setMaxInactiveInterval(1200); // 20mn (1min->60s)
		return utilisateurDto;
	}

	
	/**
	 * 
	 * @Param utilisateurDao
	 * 
	 */
	@Override
	public UtilisateurDto registration(UtilisateurDao dao){
		
		if(this.utilisateurRepo.findByEmail(dao.getEmail()) == null) {
			Role role = this.roleRepository.findByRole(dao.getRole());
			return this.utilisateurMapper.convertEntityToDto(this.saveUser(dao, role));
		} else {
			UtilisateurDto utilisateurDto = modelMapper.map(dao, UtilisateurDto.class);
			utilisateurDto.setResponses("L'utilisateur<email> "+dao.getEmail()+" Existe dejà");
			return utilisateurDto;
		}
	}
	
	private User saveUser(UtilisateurDao utilisateurDao, Role role) {
		
		List<Role> roles = new ArrayList<>();
		User user = new User();
		roles.add(role);	
		user.setPassword(utilisateurDao.getPassword());
		user.setEmail(utilisateurDao.getEmail());
		user.setEnabled(true);
		user.setModificationcounter(0);
		user.setNom(utilisateurDao.getNom());
		user.setPrenom(utilisateurDao.getPrenom());
		user.setCreate_at(LocalDateTime.now());
		user.setRole(roles);
		
		this.utilisateurRepo.saveAndFlush(user);
		
		return user;
	}

}
