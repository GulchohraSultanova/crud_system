package edu.cs.crud.crud_system.service;

import edu.cs.crud.crud_system.model.Human;
import jakarta.persistence.Id;

import java.util.List;

public interface HumanService {
    List<Human> getAllHumans();
    Human getHumanById(Long id);
    void createHuman(Human human);
}
