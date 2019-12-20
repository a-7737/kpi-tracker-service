package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.User;
import com.ibs.kpitrackerservice.respository.UserRepository;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getTeam(String id) {
        return userRepository.findById(id);
    }
}
