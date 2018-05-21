package mobalDev.logic.utilisateur.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

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
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Inject
	private UtilisateurRepository utilisateurRepo;
	
	@Inject
	private RoleRepository roleRepository;
	
	@Inject
	UtilisateurMapper utilisateurMapper;
	
	@Override
	/**
	 * 
	 * @Param utilisateurDao et l'objet auth
	 * cette methode recupere les info de l'utilisateur lors de la connexion
	 * 
	 */
	public UtilisateurDto authentification(UtilisateurDao utilisateurDao, Authentication auth) {
		
		UtilisateurDto utilisateurDto = new UtilisateurDto();
		utilisateurDto.setEmail(utilisateurDao.getEmail());
		utilisateurDto.setPassword(auth == null ? utilisateurDao.getPasswrd() : null);
		if(auth != null){
			List<RoleUtilisateurEnum> roles = new ArrayList<>();
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			utilisateurDto.setNom(auth.getName());
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
						}
			});
			utilisateurDto.setRole(roles);
		}
		
		return utilisateurDto;
	}

	@Override
	/**
	 * 
	 * @Param utilisateurDao
	 * 
	 */
	public UtilisateurDto registration(UtilisateurDao utilisateurDao) {
		
		List<Role> roles = new ArrayList<>();
		User user = new User();
		
		// On recupere le role
		Role role = this.roleRepository.findByRole(utilisateurDao.getRole());
		roles.add(role);
				
		user.setPassword(bCryptPasswordEncoder.encode(utilisateurDao.getPasswrd()));
		user.setEmail(utilisateurDao.getEmail());
		user.setEnabled(true);
		user.setModificationcounter(0);
		user.setNom(utilisateurDao.getNom());
		user.setPrenom(utilisateurDao.getPrenom());
		user.setCreate_at(LocalDateTime.now());
		user.setRole(roles);
		this.utilisateurRepo.saveAndFlush(user);
		
		return this.utilisateurMapper.convertEntityToDto(user, new UtilisateurDto());
	}

}
