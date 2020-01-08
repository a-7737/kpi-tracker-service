package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.User;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import com.ibs.kpitrackerservice.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ibs.kpitrackerservice.service.Events.Error;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User validateUser(Optional<User> user) {
        if (user.isPresent()) {
            LOGGER.info(Events.OPERATION_SUCCESSFUL.toString());
            return user.get();
        } else {
            LOGGER.error(Events.OPERATION_FAILED.toString()  + "; " + Error.USER_NOT_FOUND.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Error.getMessage(Error.USER_NOT_FOUND));
        }
    }

    public User getUserByName(String name) {
        Optional<User> user = userRepository.findByEmployeeName(name);
        return validateUser(user);
    }

    public User getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        return validateUser(user);
    }

    public User getUser(String username, String password) {
        Optional<User> user = userRepository.findUserByUserNameAndPassword(username, password);
        return validateUser(user);
    }

    public String createUser(User user) {
        user.setTeam(teamRepository.findByName(user.getTeam().getName()).get());
        userRepository.insert(user);
        return Events.getMessage(Events.OPERATION_SUCCESSFUL);
    }

    public String updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            userRepository.save(user);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        else {
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }

    public String deleteUser(String id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        else {
            return Events.getMessage(Events.OPERATION_FAILED) + ";  " + Error.getMessage(Error.USER_NOT_FOUND);
        }
    }


}
