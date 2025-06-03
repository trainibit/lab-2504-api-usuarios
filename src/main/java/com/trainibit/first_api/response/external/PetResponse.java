package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResponse {
    private String name;
    private ResultResponse result;
}