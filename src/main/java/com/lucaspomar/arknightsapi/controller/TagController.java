package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Tag;
import com.lucaspomar.arknightsapi.repository.TagRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list() {
        return tagRepository.findAll();
    }

    @GetMapping("/{tagIdOrName}")
    public Tag search(@PathVariable String tagIdOrName) {
        try {
            Long number = Long.parseLong(tagIdOrName);
            return tagRepository.getById(number);
        } catch (NumberFormatException ex) {
            return tagRepository.findByName(WordUtils.capitalizeFully(tagIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Tag add(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @PutMapping
    public Tag update(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<String> delete(@PathVariable Long tagId) {
        tagRepository.deleteById(tagId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
