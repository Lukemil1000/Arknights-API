package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Affiliation;
import com.lucaspomar.arknightsapi.repository.AffiliationRepository;
import org.apache.commons.text.WordUtils;
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

    @GetMapping("/{affiliationIdOrName}")
    public Affiliation search(@PathVariable String affiliationIdOrName) {
        try{
            Long number = Long.parseLong(affiliationIdOrName);
            return affiliationRepository.getById(number);
        }
        catch (NumberFormatException ex){
            return affiliationRepository.findByName(WordUtils.capitalizeFully(affiliationIdOrName.toLowerCase()));
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
