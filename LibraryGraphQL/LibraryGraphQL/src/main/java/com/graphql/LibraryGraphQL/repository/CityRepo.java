package com.graphql.LibraryGraphQL.repository;

import com.graphql.LibraryGraphQL.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
}
