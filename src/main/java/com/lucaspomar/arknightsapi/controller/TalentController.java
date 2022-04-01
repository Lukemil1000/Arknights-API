package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Talent;
import com.lucaspomar.arknightsapi.repository.TalentRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talent")
public class TalentController {

    @Autowired
    private TalentRepository talentRepository;

    @GetMapping
    public List<Talent> list() {
        return talentRepository.findAll();
    }

    @GetMapping("/{talentIdOrName}")
    public Talent search(@PathVariable String talentIdOrName) {
        try {
            Long number = Long.parseLong(talentIdOrName);
            return talentRepository.getById(number);
        } catch (NumberFormatException ex) {
            return talentRepository.findByName(WordUtils.capitalizeFully(talentIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Talent add(@RequestBody Talent talent) {
        return talentRepository.save(talent);
    }

    @PutMapping
    public Talent update(@RequestBody Talent talent) {
        return talentRepository.save(talent);
    }

    @DeleteMapping("/{talentId}")
    public ResponseEntity<String> delete(@PathVariable Long talentId) {
        talentRepository.deleteById(talentId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
