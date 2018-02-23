package com.prizy.services.intf;

import java.util.List;

import com.prizy.entities.Location;

public interface ILocationService {

	public Location getLastLocOfUser(long userId);

	public List<Location> getLocationsOfUser(long userId);

	public void saveLocation(Location loc);

}
