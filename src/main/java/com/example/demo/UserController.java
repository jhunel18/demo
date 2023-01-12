package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/users")
public class UserController {

        // simulate database
    Map<String, User> userMap = new HashMap<>();

    // key, value
    // email, User
    // rm@gmail.com | User(rm, rm@gmail.com)

    // database
    // id | name | email
    // 1  |  rm  | rm@gmail.com

    @PostMapping
    public User createUser(@RequestBody User user) {
        String email = user.getEmail();

        userMap.put(user.getEmail(), user);
        return user;
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Collection<User> values = userMap.values();
        return values;
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userMap.get(email);
    }

    @PutMapping("/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user) {
        return userMap.put(email, user);
        //return user;
    }

    @DeleteMapping("/{email}")
    public void deleteUserByEmail(@PathVariable String email) {
        userMap.remove(email);
    }

    //Array

}
