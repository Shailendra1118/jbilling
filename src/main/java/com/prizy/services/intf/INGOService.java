package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.NGO;

public interface INGOService {

	public List<NGO> getAllNGO();

	public NGO getNGOById(Long id);

}
