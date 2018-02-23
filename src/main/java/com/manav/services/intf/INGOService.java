package com.manav.services.intf;

import java.util.List;

import com.manav.entities.NGO;

public interface INGOService {
	
	public List<NGO> getAllNGO();
	
	public NGO getNGOById(Long id);

}
