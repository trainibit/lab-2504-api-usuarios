package com.trainibit.first_api.client.impl;

import com.trainibit.first_api.client.PlanetClient;
import com.trainibit.first_api.response.external.PlanetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlanetClientImpl implements PlanetClient {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${clients.swapi.tech.api.planets}")
    private String CLIENT_PLANETS;

    @Override
    public PlanetResponse getPlanetById(int id) {
        String url = CLIENT_PLANETS + "/" + id;
        return restTemplate.getForObject(url, PlanetResponse.class);
    }
}
