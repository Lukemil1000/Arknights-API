package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Class;
import com.lucaspomar.arknightsapi.repository.ClassRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @GetMapping
    public List<Class> list(){
        return classRepository.findAll();
    }

    @GetMapping("/{classIdOrName}")
    public Class search(@PathVariable String classIdOrName) {
        try {
            Long number = Long.parseLong(classIdOrName);
            return classRepository.getById(number);
        }catch (NumberFormatException ex) {
            return classRepository.findByName(WordUtils.capitalizeFully(classIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Class add(@RequestBody Class classs) {
        return classRepository.save(classs);
    }

    @PutMapping
    public Class update(@RequestBody Class classs) {
        return classRepository.save(classs);
    }

    @DeleteMapping("/ClassId")
    public ResponseEntity<String> delete(@PathVariable Long classId) {
        classRepository.deleteById(classId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
