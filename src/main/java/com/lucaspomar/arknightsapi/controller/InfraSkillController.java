package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.InfraSkill;
import com.lucaspomar.arknightsapi.repository.InfraSkillRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infraskill")
public class InfraSkillController {

    @Autowired
    private InfraSkillRepository infraSkillRepository;

    @GetMapping
    public List<InfraSkill> list() {
        return infraSkillRepository.findAll();
    }

    @GetMapping("/{infraSkillIdOrName}")
    public InfraSkill search(@PathVariable String infraSkillIdOrName) {
        try{
            Long number = Long.parseLong(infraSkillIdOrName);
            return infraSkillRepository.getById(number);
        }catch (NumberFormatException ex) {
            return infraSkillRepository.findByName(WordUtils.capitalizeFully(infraSkillIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public InfraSkill add(@RequestBody InfraSkill infraSkill) {
        return infraSkillRepository.save(infraSkill);
    }

    @PutMapping
    public InfraSkill update(@RequestBody InfraSkill infraSkill) {
        return infraSkillRepository.save(infraSkill);
    }

    @DeleteMapping("/{infraSkillId}")
    public ResponseEntity<String> delete(@PathVariable Long infraSkillId) {
        infraSkillRepository.deleteById(infraSkillId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
