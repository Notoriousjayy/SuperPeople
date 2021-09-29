package com.example.SuperPeople.Service;

import com.example.SuperPeople.DAO.SuperPersonRepository;
import com.example.SuperPeople.Entity.SuperPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperPersonService {
    private final SuperPersonRepository superPersonRepository;

    public SuperPersonService(SuperPersonRepository superPersonRepository) {
        this.superPersonRepository = superPersonRepository;
    }

    public List<SuperPerson> getAllSuperPeople(){
        return superPersonRepository.findAll();
    }

    public Object findById(String id){
        return superPersonRepository.findById(id);
    }

    public void deleteById(String id){
        superPersonRepository.deleteById(id);
    }

    public void save(SuperPerson superPerson){
        superPersonRepository.save(superPerson);
    }


}
