package com.trainibit.first_api.client;

import com.trainibit.first_api.response.external.PetResponse;
import com.trainibit.first_api.response.external.PlanetResponse;

public interface PetClient {
    PetResponse getPetById(int id);
}