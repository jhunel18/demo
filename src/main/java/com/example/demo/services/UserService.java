package com.example.demo.services;

import com.example.demo.dto.UserDto;
import com.example.demo.models.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final int PAGE_SIZE = 10;

    @Autowired
    UserRepository userRepository;

    public Users addUser(UserDto userDto) {
        Users user = new Users();
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setCourse(userDto.getCourse());
        user.setYear(userDto.getYear());

        return userRepository.save(user);
    }

    public List<Users> getAllUsers(int page) {
        int zeroBasedPage = Math.max(page - 1, 0);
        Page<Users> result = userRepository.findAll(PageRequest.of(zeroBasedPage, PAGE_SIZE));
        return result.getContent();
    }

    public Optional<Users> getUserById(long id) {
        return userRepository.findById(id);
    }

    public Optional<Users> updateUser(long id, UserDto userDto) {
        Optional<Users> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            Users userToUpdate = existingUser.get();
            userToUpdate.setFirstName(userDto.getFirstName());
            userToUpdate.setMiddleName(userDto.getMiddleName());
            userToUpdate.setLastName(userDto.getLastName());
            userToUpdate.setEmail(userDto.getEmail());
            userToUpdate.setCourse(userDto.getCourse());
            userToUpdate.setYear(userDto.getYear());
            return Optional.of(userRepository.save(userToUpdate));
        }
        return Optional.empty();
    }

    public boolean deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
