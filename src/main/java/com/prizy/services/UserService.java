package com.prizy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prizy.entities.AppUser;
import com.prizy.entities.EntryPass;
import com.prizy.entities.repo.UserRepository;
import com.prizy.entities.repo.intf.IUserRepository;
import com.prizy.services.intf.IUserService;

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
