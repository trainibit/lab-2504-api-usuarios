package com.trainibit.first_api.service;

import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll();
    UserResponse getByUUID(String id);
    UserResponse createUser(UserRequest userRequest);
}
