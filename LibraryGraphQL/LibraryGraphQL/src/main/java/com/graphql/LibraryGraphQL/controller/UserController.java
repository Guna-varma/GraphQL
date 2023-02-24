package com.graphql.LibraryGraphQL.controller;

import com.graphql.LibraryGraphQL.domain.User;
import com.graphql.LibraryGraphQL.repository.UserRepo;
import com.graphql.LibraryGraphQL.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserRepo repo;

    @MutationMapping("addUser")
    public User addUser(@Argument UserInput userInput) {
        User u = new User();
        u.setId(userInput.getId());
        u.setName(userInput.getName());
        u.setLibId(userInput.getLibId());
        return service.addUser(u);
    }

    @QueryMapping("getAllUser")
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @QueryMapping("getUserById ")
    public Optional<User> getUserById(@Argument Integer id) {
        return service.getUserById(id);
    }

    @QueryMapping("countUser")
    public Integer countUser() {
        return service.countUser();
    }

    @MutationMapping("deleteUser")
    public Boolean deleteUser(@Argument Integer id) {
        return service.deleteUser(id);
    }

    @MutationMapping("updateUser")
    public User updateUser(@Argument Integer id, @Argument String name) {
        Optional<User> userOptional = repo.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(name);

            repo.save(user);
            return user;
        }

        throw new NoSuchElementException();
    }

}

@Getter
@Setter
class UserInput {
    private Integer id;
    private String name;
    private Integer libId;
}