package org.sid.registerequestre;

import org.sid.registerequestre.dao.TacheRepository;
import org.sid.registerequestre.entities.AppRole;
import org.sid.registerequestre.entities.AppUser;
import org.sid.registerequestre.entities.Tache;
import org.sid.registerequestre.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class RegisterEquestreApplication implements CommandLineRunner {

    @Autowired
    private TacheRepository tacheRepository;

    @Autowired
    private AccountService accountService;


    public static void main(String[] args) {
        SpringApplication.run(RegisterEquestreApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser(null,"admin@gmail.com", "12345", null,  null, null, null));
        accountService.saveUser(new AppUser(null,"user@gmail.com", "1234", null, null, null, null));
        accountService.saveRole(new AppRole(null, "ADMIN"));
        accountService.saveRole(new AppRole(null, "USER"));
        accountService.addRoleToUser("admin@gmail.com", "ADMIN");
        accountService.addRoleToUser("admin@gmail.com", "USER");
        accountService.addRoleToUser("user@gmail.com", "USER");
        Stream.of("T1", "T2", "T3").forEach(t->{
            tacheRepository.save(new Tache(null,t));
        });
        tacheRepository.findAll().forEach(t->{
            System.out.println(t.getTacheName());
        });
    }
}
