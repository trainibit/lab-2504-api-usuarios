package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
