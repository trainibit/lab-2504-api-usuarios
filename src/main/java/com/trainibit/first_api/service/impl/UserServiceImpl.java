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

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanetClient planetClient;

    @Autowired
    private PetClient petClient;

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
        newUser.setUUID(UUID.randomUUID());
        newUser.setCreatedDate(currentTimeStamp);
        newUser.setUpdatedDate(currentTimeStamp);

        //PLANETA ALEATORIO
        Random random = new Random();
        int randomNumber = random.nextInt(60) + 1;
        PlanetResponse randomPlanet = planetClient.getPlanetById(randomNumber);
        newUser.setPlanet(randomPlanet.getResult().getProperties().getName());

        //MASCOTA ALEATORIA
        PetResponse selectedPet = null;
        int maxTries = 5;

        for (int i = 0; i < maxTries; i++) {
            int randomPetId = random.nextInt(60) + 1;
            selectedPet = petClient.getPetById(randomPetId);
            if (selectedPet != null) {
                break;
            }
        }

        if (selectedPet != null) {
            newUser.setPet(selectedPet.getName());
        } else {
            newUser.setPet("Mascota no disponible");
        }

        return userMapper.entityToResponse(userRepository.save(newUser));
    }
}
