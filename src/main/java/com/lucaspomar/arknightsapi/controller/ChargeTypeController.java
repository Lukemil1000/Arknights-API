package com.lucaspomar.arknightsapi.controller;

import com.lucaspomar.arknightsapi.model.ChargeType;
import com.lucaspomar.arknightsapi.repository.ChargeTypeRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chargetype")
public class ChargeTypeController {

    @Autowired
    private ChargeTypeRepository chargeTypeRepository;

    @GetMapping
    public List<ChargeType> list() {
        return chargeTypeRepository.findAll();
    }

    @PostMapping
    public ChargeType add(@RequestBody ChargeType chargeType) {
        return chargeTypeRepository.save(chargeType);
    }

    @GetMapping("/{chargeTypeIdOrName}")
    public ChargeType search(@PathVariable String chargeTypeIdOrName) {
        try{
            Long number = Long.parseLong(chargeTypeIdOrName);
            return chargeTypeRepository.getById(number);
        }
        catch (NumberFormatException ex){
            return chargeTypeRepository.findByName(WordUtils.capitalizeFully(chargeTypeIdOrName.toLowerCase()));
        }
    }

    @PutMapping
    public ChargeType update(@RequestBody ChargeType chargeType) {
        return chargeTypeRepository.save(chargeType);
    }

    @DeleteMapping("/{chargeTypeId}")
    public ResponseEntity<String> delete(@PathVariable Long chargeTypeId) {
        chargeTypeRepository.deleteById(chargeTypeId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
