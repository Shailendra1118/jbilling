package com.prizy.services.intf;

import com.prizy.entities.AppUser;
import com.prizy.entities.EntryPass;

public interface IUserService {

	public AppUser getUserById(EntryPass creds);

	public AppUser getUser(EntryPass pass);

	public void saveUser(AppUser user);

}
