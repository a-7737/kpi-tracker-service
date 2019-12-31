package com.ibs.kpitrackerservice.controller;

import com.ibs.kpitrackerservice.model.User;
import com.ibs.kpitrackerservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(path = "/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping(path = "/user/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping(path = "/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping(path = "/user/{name}")
    public ResponseEntity<User> getByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> getByID(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
