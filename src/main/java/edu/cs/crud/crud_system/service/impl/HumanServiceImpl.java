package edu.cs.crud.crud_system.service.impl;

import edu.cs.crud.crud_system.enums.SexEnum;
import edu.cs.crud.crud_system.model.Human;
import edu.cs.crud.crud_system.repository.HumanRepository;
import edu.cs.crud.crud_system.service.HumanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;

    @Override
    public List<Human> getAllHumans() {
        return humanRepository.findAll();
    }

    @Override
    public Human getHumanById(Long id) {
        return humanRepository.findById(id).orElse(null);
    }

    @Override
    public void createHuman(Human human) {
        humanRepository.save(human);
    }
}
