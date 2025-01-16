package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertiesResultPlanetResponse {
    private String diameter;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surfaceWater;
    private String created;
    private String edited;
    private String name;
    private String url;
}
