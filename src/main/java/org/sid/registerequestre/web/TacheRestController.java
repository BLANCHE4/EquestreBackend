package org.sid.registerequestre.web;

import org.sid.registerequestre.dao.TacheRepository;
import org.sid.registerequestre.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TacheRestController {

    @Autowired
    private TacheRepository tacheRepository;

    @GetMapping("/taches")
    public List<Tache> listTaches(){
        return tacheRepository.findAll();
    }

    @PostMapping("/taches")
    @ResponseBody
    public Tache save(@RequestBody Tache t){
        return tacheRepository.save(t);
    }
}
