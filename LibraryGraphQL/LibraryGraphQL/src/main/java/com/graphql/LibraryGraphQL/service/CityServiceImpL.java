package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityServiceImpL {

    City addCity(City city);

    List<City> getAllCity();

    Optional<City> getCityById(Integer id);

//    City updateCity(City city);

    Boolean deleteCity(Integer id);

    Integer countCity();
}
