package com.trainibit.first_api.client;

import com.trainibit.first_api.response.external.PlanetResponse;

public interface PlanetClient {
    PlanetResponse getPlanetById(int id);
}