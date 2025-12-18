package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        return repo.save(user);
    }

    public User getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User update(Long id, User user) {
        User u = getById(id);
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        return repo.save(u);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}