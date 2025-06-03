package com.trainibit.first_api.service.impl;

import com.trainibit.first_api.client.PetClient;
import com.trainibit.first_api.client.PlanetClient;
import com.trainibit.first_api.entity.User;
import com.trainibit.first_api.mapper.UserMapper;
import com.trainibit.first_api.repository.UserRepository;
import com.trainibit.first_api.request.UserRequest;
import com.trainibit.first_api.response.UserResponse;
import com.trainibit.first_api.response.external.PetResponse;
import com.trainibit.first_api.response.external.PlanetResponse;
import com.trainibit.first_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlanetClient planetClient;

    @Autowired
    private PetClient petClient;


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
        newUser.setUUID(UUID.randomUUID());
        newUser.setCreatedDate(currentTimeStamp);
        newUser.setUpdatedDate(currentTimeStamp);

        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetClient.getPlanetById(randomNumber);
        newUser.setPlanet(randomPlanet.getResult().getProperties().getName());

        try {
            PetResponse randomPet = petClient.getPetById(randomNumber);
            newUser.setPet(randomPet.getName());

        }catch (HttpClientErrorException.NotFound e){
            newUser.setPet("Unknown Pet");
            System.err.println("Pet not found: " + e.getMessage());
        }

        return userMapper.entityToResponse(userRepository.save(newUser));
    }

}
