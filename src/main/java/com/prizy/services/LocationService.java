package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.Location;
import com.prizy.services.intf.ILocationService;
import com.prizy.services.intf.IUserService;

@Service
public class LocationService implements ILocationService {

	@Autowired
	private IUserService usrvc;

	@Override
	public List<Location> getLocationsOfUser(long userId) {
		return null;
	}

	@Override
	public void saveLocation(Location loc) {

	}

	@Override
	public Location getLastLocOfUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
