package org.sid.registerequestre.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegisterForm {
    private String nom;
    private String prenom;
    private String telephone;
    private String numeroLicence;
    private String username;
    private String password;
    private String repassword;
}
