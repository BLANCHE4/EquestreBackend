package org.sid.registerequestre.service;

import org.sid.registerequestre.entities.AppRole;
import org.sid.registerequestre.entities.AppUser;

public interface AccountService {

    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username, String roleName);
    public AppUser findUserByUsername(String username);
}
