package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultPlanetResponse {
    private PropertiesResultPlanetResponse propertiesResultPlanetResponse;
    private String description;
    private String id;
    private String uid;
    private int v;
}