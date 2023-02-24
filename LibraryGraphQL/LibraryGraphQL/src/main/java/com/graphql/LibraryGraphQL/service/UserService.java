package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.User;
import com.graphql.LibraryGraphQL.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImpL{

    @Autowired
    private UserRepo repo;

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Integer countUser() {
        return Math.toIntExact(repo.count());
    }

}