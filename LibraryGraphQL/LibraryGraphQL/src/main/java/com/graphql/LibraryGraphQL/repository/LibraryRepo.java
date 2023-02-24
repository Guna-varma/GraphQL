package com.graphql.LibraryGraphQL.repository;

import com.graphql.LibraryGraphQL.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer> {
}
