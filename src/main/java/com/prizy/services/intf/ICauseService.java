package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.Cause;

public interface ICauseService {

	public List<Cause> getByType(String type);

}
