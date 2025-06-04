package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResponse {
    private int id;
    private String name;
    private PetCategory petCategory;
    private PetTag petTag;
    private String status;
}
