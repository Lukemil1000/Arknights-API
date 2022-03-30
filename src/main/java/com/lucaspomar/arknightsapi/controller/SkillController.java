package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Skill;
import com.lucaspomar.arknightsapi.repository.SkillRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public List<Skill> list() {
        return skillRepository.findAll();
    }

    @GetMapping("/{skillIdOrName}")
    public Skill search(@PathVariable String skillIdOrName) {
        try {
            Long number = Long.parseLong(skillIdOrName);
            return skillRepository.getById(number);
        }catch (NumberFormatException ex) {
            return skillRepository.findByName(WordUtils.capitalizeFully(skillIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Skill add(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @PutMapping
    public Skill update(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @DeleteMapping("/{skillId}")
    public ResponseEntity<String> delete(@PathVariable Long skillId) {
        skillRepository.deleteById(skillId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
