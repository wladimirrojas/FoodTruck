package com.foodapp.foodtruck.services;

import com.foodapp.foodtruck.client.PokemonClient;
import com.foodapp.foodtruck.dto.PokemonDto;
import io.reactivex.rxjava3.core.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokemonClient pokemonClient;

    @Autowired
    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public Observable<PokemonDto> getPokemonById(int id) {
        return pokemonClient.getPokemonById(id);
    }
}
