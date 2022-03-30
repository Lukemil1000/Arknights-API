package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.SkillActivation;
import com.lucaspomar.arknightsapi.repository.SkillActivationRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skillactivation")
public class SkillActivationController {

    @Autowired
    private SkillActivationRepository skillActivationRepository;

    @GetMapping
    public List<SkillActivation> list() {
        return skillActivationRepository.findAll();
    }

    @GetMapping("/{skillActivationIdOrName}")
    public SkillActivation search(@PathVariable String skillActivationIdOrName) {
        try {
            Long number = Long.parseLong(skillActivationIdOrName);
            return skillActivationRepository.getById(number);
        }catch (NumberFormatException ex) {
            return skillActivationRepository.findByName(WordUtils.capitalizeFully(skillActivationIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public SkillActivation add(@RequestBody SkillActivation skillActivation) {
        return skillActivationRepository.save(skillActivation);
    }

    @PutMapping
    public SkillActivation update(@RequestBody SkillActivation skillActivation) {
        return skillActivationRepository.save(skillActivation);
    }

    @DeleteMapping("/{skillActivationId}")
    public ResponseEntity<String> delete(@PathVariable Long skillActivationId) {
        skillActivationRepository.deleteById(skillActivationId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
