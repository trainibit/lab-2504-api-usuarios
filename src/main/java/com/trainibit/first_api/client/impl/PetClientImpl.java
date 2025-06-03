package com.trainibit.first_api.client.impl;

import com.trainibit.first_api.client.PetClient;
import com.trainibit.first_api.response.external.PetResponse;
import com.trainibit.first_api.response.external.PlanetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PetClientImpl implements PetClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("https://petstore.swagger.io/v2/pet")
    private String CLIENT_PETS;

    @Override
    public PetResponse getPetById(int id) {
        String url = CLIENT_PETS + "/" + id;
        return restTemplate.getForObject(url, PetResponse.class);
    }

}
