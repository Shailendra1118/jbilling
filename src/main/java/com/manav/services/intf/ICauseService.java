package com.manav.services.intf;

import java.util.List;

import com.manav.entities.Cause;

public interface ICauseService {
	
	public List<Cause> getByType(String type);

}
