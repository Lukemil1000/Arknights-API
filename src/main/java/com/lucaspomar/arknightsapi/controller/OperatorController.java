package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.Operator;
import com.lucaspomar.arknightsapi.repository.OperatorRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private OperatorRepository operatorRepository;

    @GetMapping
    public List<Operator> list() {
        return operatorRepository.findAll();
    }

    @GetMapping("/{operatorIdOrName}")
    public Operator search(@PathVariable String operatorIdOrName) {
        try {
            Long number = Long.parseLong(operatorIdOrName);
            return operatorRepository.getById(number);
        }catch (NumberFormatException ex) {
            return operatorRepository.findByName(WordUtils.capitalizeFully(operatorIdOrName.toLowerCase()));
        }
    }

    @PostMapping
    public Operator add(@RequestBody Operator operator) {
        return operatorRepository.save(operator);
    }

    @PutMapping
    public Operator update(@RequestBody Operator operator) {
        return operatorRepository.save(operator);
    }

    @DeleteMapping("/{operatorId}")
    public ResponseEntity<String> delete(@PathVariable Long operatorId) {
        operatorRepository.deleteById(operatorId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
