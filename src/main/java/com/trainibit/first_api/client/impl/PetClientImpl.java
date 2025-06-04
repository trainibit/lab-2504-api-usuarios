package com.trainibit.first_api.client.impl;

import com.trainibit.first_api.client.PetClient;
import com.trainibit.first_api.response.external.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class PetClientImpl implements PetClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${clients.petstore.api.pets}")
    private String CLIENT_PETS;

    @Override
    public PetResponse getPetById(long id) {
        String url = CLIENT_PETS + "/" + id;
        try {
            return restTemplate.getForObject(url, PetResponse.class);
        }catch (HttpClientErrorException.NotFound ex) {
            System.out.println("Mascota con ID " + id + " no encontrada.");
            return null;
        }
    }
}
