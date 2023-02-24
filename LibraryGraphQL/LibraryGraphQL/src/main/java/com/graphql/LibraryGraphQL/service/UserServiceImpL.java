package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.City;
import com.graphql.LibraryGraphQL.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceImpL {

    User addUser(User user);

    List<User> getAllUser();

    Optional<User> getUserById(Integer id);

    Boolean deleteUser(Integer id);

    Integer countUser();


}
