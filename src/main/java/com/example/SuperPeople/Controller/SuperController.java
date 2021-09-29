package com.example.SuperPeople.Controller;

import com.example.SuperPeople.Entity.SuperPerson;
import com.example.SuperPeople.Service.SuperPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superPersons")
public class SuperController {
    
    private final SuperPersonService superPersonService;

    public SuperController(SuperPersonService superPersonService) {
        this.superPersonService = superPersonService;
    }

    @GetMapping
    public List<SuperPerson> getAllSuperPersons(){
        return superPersonService.getAllSuperPeople();
    }

    @PostMapping( "/addSuperPerson" )
    public SuperPerson addSuperPerson(@RequestBody SuperPerson superPerson) {
        superPersonService.save(superPerson);
        return superPerson;
    }

    @GetMapping( "retrieveSuperPerson/{id}" )
    public Object getSuperPersonById(@PathVariable String id) {
        superPersonService.findById(id);
        return "Retrieved part id : " + id;
    }

    @PutMapping({ "/updateSuperPerson" })
    public SuperPerson UpdateSuperPerson(@RequestBody SuperPerson superPerson) {
        superPersonService.save(superPerson);
        return superPerson;
    }

    @DeleteMapping({ "/deleteSuperPerson/{id}" })
    public ResponseEntity<?> deleteSuperPerson(@PathVariable String id){
        superPersonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
