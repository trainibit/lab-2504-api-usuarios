package com.trainibit.first_api.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private UUID uuid;
    private LocalDate birthDate;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String age;
}
