package com.trainibit.first_api.client;

import com.trainibit.first_api.response.external.PetResponse;

public interface PetClient {
    PetResponse getPetById(int id);
}
