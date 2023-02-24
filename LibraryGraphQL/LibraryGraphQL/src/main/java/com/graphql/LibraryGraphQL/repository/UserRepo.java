package com.graphql.LibraryGraphQL.repository;

import com.graphql.LibraryGraphQL.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
