package com.manav.services;

import com.manav.entities.EntryPass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.manav.entities.AppUser;
import com.manav.entities.repo.UserRepository;
import com.manav.entities.repo.intf.IUserRepository;
import com.manav.services.intf.IUserService;

@Service
public class UserService implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private IUserRepository repo = new UserRepository();

    @Override
    public AppUser getUserById(EntryPass creds) {
        return this.repo.getUserById(creds);
    }

    @Override
    public AppUser getUser(EntryPass creds) {
        AppUser u = this.repo.getUser(creds);

        if (u == null) {
            logger.error("User validation failed with " + creds.getUname());
            throw new RuntimeException("Invalid User!");
        } else {
            logger.info("User " + u.getfName() + " successfully authenticated.");
            return u;
        }
    }

    @Override
    public void saveUser(AppUser user) {
        // TODO
        logger.info("Yet to implement saveUser.");
    }


}
