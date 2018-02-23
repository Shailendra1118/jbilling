package com.prizy.entities.repo.intf;

import com.prizy.entities.AppUser;
import com.prizy.entities.EntryPass;

public interface IUserRepository {

	public AppUser getUserById(EntryPass creds);

	public AppUser getUser(EntryPass creds);

}
