package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultPlanetResponse {
    private PropertiesResultPlanetResponse properties;
    private String description;
    private String _id;
    private String uid;
    private int __v;
}