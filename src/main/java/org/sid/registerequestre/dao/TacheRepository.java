package org.sid.registerequestre.dao;

import org.sid.registerequestre.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository  extends JpaRepository<Tache, Long> {

}
