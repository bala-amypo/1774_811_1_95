package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.model.*;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
