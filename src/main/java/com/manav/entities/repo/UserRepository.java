package com.manav.entities.repo;

import com.manav.entities.AppUser;
import com.manav.entities.EntryPass;
import com.manav.entities.repo.intf.IUserRepository;

import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static List<AppUser> appUserList = new LinkedList<>();

    static AppUser u1 = null;

    static String uname = "abc@gmail.com";
    static String pwd = "123";

    static {
        u1 = new AppUser();
        u1.setId(99);
        u1.setfName("Ashish");
        u1.setlName("Kumar");
        u1.setAddress("Pune");

        EntryPass pass = new EntryPass();
        pass.setUname(uname);
        pass.setPwd(pwd);
        u1.setPass(pass);

        appUserList.add(u1);
    }

    @Override
    public AppUser getUserById(EntryPass creds) {
        return u1;
    }


    @Override
    public AppUser getUser(EntryPass creds) {

        //TODO: this will be actually coming from database and not the actual iteration of the user list

        for (AppUser user : appUserList) {
            if (user.getPass().getUname().equals(creds.getUname()) && user.getPass().getPwd().equals(creds.getPwd())) {
                return user;
            }
        }
        //TODO: handle more nicely
        System.out.println("Unable to find user");
        return null;

    }
}