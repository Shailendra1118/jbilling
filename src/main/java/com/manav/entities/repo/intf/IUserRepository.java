package com.manav.entities.repo.intf;

import com.manav.entities.AppUser;
import com.manav.entities.EntryPass;

public interface IUserRepository {

    public AppUser getUserById(EntryPass creds);

    public AppUser getUser(EntryPass creds);

}
