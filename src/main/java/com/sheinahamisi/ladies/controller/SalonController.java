package com.sheinahamisi.ladies.controller;

import com.sheinahamisi.ladies.dtos.SalonDto;
import com.sheinahamisi.ladies.entity.Salon;
import com.sheinahamisi.ladies.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/salons")
public class SalonController {
    private final SalonService salonService;

    @PostMapping("new")
    public ResponseEntity<String> addSalon(@RequestBody SalonDto salonDto) {
        salonService.addSalon(salonDto);
        return new ResponseEntity<>("salon added successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Salon>> allSalons() {
        return new ResponseEntity<>(salonService.allSalons(), HttpStatus.OK);
    }

    @GetMapping("id/{salonId}")
    public ResponseEntity<Salon> findSalon(@PathVariable("salonId") Long salonId) {
        return new ResponseEntity<>(salonService.findSalon(salonId), HttpStatus.OK);
    }

    @PutMapping("id/{salonId}")
    public ResponseEntity<String> updateSalon(@PathVariable("salonId") Long salonId, @RequestBody SalonDto salonDto) {
        salonService.updateSalon(salonId, salonDto);
        return new ResponseEntity<>("salon updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("id/{salonId}")
    public ResponseEntity<String> deleteSalon(@PathVariable("salonId") Long salonId) {
        salonService.deleteSalon(salonId);
        return new ResponseEntity<>("salon deleted successfully", HttpStatus.OK);
    }
}
