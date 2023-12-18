/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */
package com.example.wordlyweek.controller;

import com.example.wordlyweek.model.*;
import com.example.wordlyweek.service.MagazineJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MagazineController {

    @Autowired
    public MagazineJpaService magazineJpaService;

    @GetMapping("/magazines")
    public ArrayList<Magazine> getMagazines() {
        return magazineJpaService.getMagazines();
    }

    @GetMapping("/magazines/{magazineId}")
    public Magazine getMagazineById(@PathVariable("magazineId") int magazineId) {
        return magazineJpaService.getMagazineById(magazineId);
    }

    @PostMapping("/magazines")
    public Magazine addMagazine(@RequestBody Magazine magazine) {
        return magazineJpaService.addMagazine(magazine);
    }

    @PutMapping("/magazines/{magazineId}")
    public Magazine updateMagazine(@PathVariable("magazineId") int magazineId, @RequestBody Magazine magazine) {
        return magazineJpaService.updateMagazine(magazineId, magazine);
    }

    @DeleteMapping("/magazines/{magazineId}")
    public void deleteMagazine(@PathVariable("magazineId") int magazineId) {
        magazineJpaService.deleteMagazine(magazineId);
    }

    @GetMapping("/magazines/{magazineId}/writers")
    public List<Writer> getMagazinerWriters(@PathVariable("magazineId") int magazineId) {
        return magazineJpaService.getMagazinerWriters(magazineId);
    }

}