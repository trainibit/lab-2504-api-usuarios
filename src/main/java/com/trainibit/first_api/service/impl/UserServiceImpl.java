package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> getAll() {
        return userMapper.entityToResponseList(userRepository .findAll());
    }

    @Override
    public UserResponse getByUUID(String uuid) {
        return userMapper.entityToResponse(userRepository.findByUUID(UUID.fromString(uuid)));
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User newUser = userMapper.requestToEntity(userRequest);

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        newUser.setUuid(UUID.randomUUID());
        newUser.setCreatedDate(currentTimeStamp);
        newUser.setUpdatedDate(currentTimeStamp);

        return userMapper.entityToResponse(userRepository.save(newUser));
    }
}
