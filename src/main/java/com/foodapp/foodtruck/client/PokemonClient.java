package com.foodapp.foodtruck.client;

import com.foodapp.foodtruck.dto.PokemonDto;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonClient {

    private RestTemplate restTemplate;
    @Value("${poke.api.url}")
    private String apiUrl;

    public PokemonClient() {
        this.restTemplate = new RestTemplate();
    }

    public Observable<PokemonDto> getPokemonById(int id){
        return Observable.fromCallable(
                () -> restTemplate.getForObject(apiUrl + id, PokemonDto.class)
        ).subscribeOn(Schedulers.io());
    }
}
