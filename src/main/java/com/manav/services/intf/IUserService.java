package com.manav.services.intf;

import com.manav.entities.AppUser;
import com.manav.entities.EntryPass;

public interface IUserService {
	
	public AppUser getUserById(EntryPass creds);
	
	public AppUser getUser(EntryPass pass);
	
	public void saveUser(AppUser user);

}
