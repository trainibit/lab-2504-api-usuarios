package com.trainibit.first_api.response.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetResponse {
    private String id;
    private CategoryResponse category;
    private String name;
    private String[] photosUrls;
    private TagResponse[] tags;
    private String status;
}
