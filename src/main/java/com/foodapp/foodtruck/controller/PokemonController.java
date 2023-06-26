package com.foodapp.foodtruck.controller;

import com.foodapp.foodtruck.dto.PokemonDto;
import com.foodapp.foodtruck.services.PokemonService;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon/")
public class PokemonController {

    private final PokemonService service;

    @Autowired
    public PokemonController(PokemonService service) {
        this.service = service;
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<Observable<PokemonDto>> getPokemonById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getPokemonById(id));

    }
}
