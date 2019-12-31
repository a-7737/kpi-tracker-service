package com.ibs.kpitrackerservice.service;

import com.ibs.kpitrackerservice.model.User;
import com.ibs.kpitrackerservice.respository.TeamRepository;
import com.ibs.kpitrackerservice.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByName(String name) {
        try {
            Optional<User> user = userRepository.findByEmployeeName(name);
            if (!user.isEmpty() && user.isPresent()) {
                LOGGER.info(Events.OPERATION_SUCCESSFUL.toString());
                return user.get();
            }
            else {
                LOGGER.error(Events.OPERATION_FAILED.toString()  + "; " + Events.NOT_FOUND.toString());
            }
        }
        catch (Exception ex) {
            LOGGER.error(Events.USER_EXCEPTION.toString());
        }
        return null;
    }

    public User getUserById(String id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (!user.isEmpty() && user.isPresent()) {
                LOGGER.info(Events.OPERATION_SUCCESSFUL.toString());
                return user.get();
            }
            else {
                LOGGER.error(Events.OPERATION_FAILED.toString()  + "; " + Events.NOT_FOUND.toString());
            }
        }
        catch (Exception ex) {
            LOGGER.error(Events.USER_EXCEPTION.toString());
        }
        return null;
    }

    public String saveUser(User user) {
        try {
            user.setTeam(teamRepository.findByName(user.getTeam().getName()).get());
            userRepository.save(user);
            return Events.getMessage(Events.OPERATION_SUCCESSFUL);
        }
        catch (Exception ex) {
            LOGGER.error(Events.USER_SAVE_EXCEPTION.toString());
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }

    public String updateUser(User user) {
        try {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if (!existingUser.isEmpty() && existingUser.isPresent()) {
                userRepository.delete(existingUser.get());
                userRepository.save(user);
                return Events.getMessage(Events.OPERATION_SUCCESSFUL);
            }
            else {
                return Events.getMessage(Events.OPERATION_FAILED);
            }
        }
        catch (Exception ex) {
            LOGGER.error(Events.USER_UPDATE_EXCEPTION.toString());
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }

    public String deleteUser(String id) {
        try {
            Optional<User> existingUser = userRepository.findById(id);
            if (!existingUser.isEmpty() && existingUser.isPresent()) {
                userRepository.delete(existingUser.get());
                return Events.getMessage(Events.OPERATION_SUCCESSFUL);
            }
            else {
                return Events.getMessage(Events.OPERATION_FAILED) + ";  " + Events.getMessage(Events.NOT_FOUND);
            }
        }
        catch (Exception ex) {
            LOGGER.error(Events.USER_DELETE_EXCEPTION.toString());
            return Events.getMessage(Events.OPERATION_FAILED);
        }
    }
}
