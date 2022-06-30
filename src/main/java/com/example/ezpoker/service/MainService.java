package com.example.ezpoker.service;

import com.example.ezpoker.entity.User;
import com.example.ezpoker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public void saveOrUpdate(User user) {
        System.out.println(user);
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
