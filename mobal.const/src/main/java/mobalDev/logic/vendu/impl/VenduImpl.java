package mobalDev.logic.vendu.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mobalDev.logic.vendu.GestionVente;
import mobalDev.logic.vendu.dto.VenduDto;

@Repository
@Transactional
@Component
public class VenduImpl implements GestionVente{

	@Override
	public void registration(List<VenduDto> list) {
		
	}

}
