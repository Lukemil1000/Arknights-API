package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Affiliation;
import com.lucaspomar.arknightsapi.repository.AffiliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affiliation")
public class AffiliationController {

    @Autowired
    private AffiliationRepository affiliationRepository;

    @GetMapping
    public List<Affiliation> list() {
        return affiliationRepository.findAll();
    }

    @PostMapping
    public Affiliation add(@RequestBody Affiliation affiliation) {
        return affiliationRepository.save(affiliation);
    }

    @GetMapping("/{affiliationId}")
    public Affiliation searchName(@PathVariable String affiliationId) {
        try{
            Long number = Long.parseLong(affiliationId);
            return affiliationRepository.getById(number);
        }
        catch (NumberFormatException ex){
            return affiliationRepository.findByName(affiliationId);
        }
    }

    @PutMapping
    public Affiliation update(@RequestBody Affiliation affiliation) {
        return affiliationRepository.save(affiliation);
    }

    @DeleteMapping("/{affiliationId}")
    public ResponseEntity<String> delete(@PathVariable Long affiliationId) {
        affiliationRepository.deleteById(affiliationId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
