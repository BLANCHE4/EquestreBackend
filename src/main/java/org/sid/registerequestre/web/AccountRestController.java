package org.sid.registerequestre.web;

import org.sid.registerequestre.entities.AppUser;
import org.sid.registerequestre.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterForm userForm){
        if(!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("Vous devez confirmer votre mot de passe");
        AppUser user=accountService.findUserByUsername(userForm.getUsername());
        if(user!=null) throw new RuntimeException("Cet utilisateur existe déjà avec cet email!");
        AppUser appUser=new AppUser();
        appUser.setNom(userForm.getNom());
        appUser.setPrenom(userForm.getPrenom());
        appUser.setTelephone(userForm.getTelephone());
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        accountService.saveUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(), "USER");
        return appUser;
    }
}
