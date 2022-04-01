package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Subclass;
import com.lucaspomar.arknightsapi.repository.SubclassRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subclass")
public class SubclassController {

    @Autowired
    private SubclassRepository subclassRepository;

    @GetMapping
    public List<Subclass> list() {
        return subclassRepository.findAll();
    }

    @GetMapping("/{subclassIdOrName}")
    public Subclass search(@PathVariable String subclassIdOrName) {
        try {
            Long number = Long.parseLong(subclassIdOrName);
            return subclassRepository.getById(number);
        }catch (NumberFormatException ex) {
            return subclassRepository.findByName(WordUtils.capitalizeFully(subclassIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Subclass add(@RequestBody Subclass subclass) {
        return subclassRepository.save(subclass);
    }

    @PutMapping
    public Subclass update(@RequestBody Subclass subclass) {
        return subclassRepository.save(subclass);
    }

    @DeleteMapping("/{subclassId}")
    public ResponseEntity<String> delete(@PathVariable Long subclassId) {
        subclassRepository.deleteById(subclassId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
