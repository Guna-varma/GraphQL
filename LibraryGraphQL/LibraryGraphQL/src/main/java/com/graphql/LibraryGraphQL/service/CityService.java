package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.City;
import com.graphql.LibraryGraphQL.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements CityServiceImpL {

    @Autowired
    private CityRepo repo;

    @Override
    public City addCity(City city) {
        return repo.save(city);
    }

    @Override
    public List<City> getAllCity() {
        return repo.findAll();
    }

    @Override
    public Optional<City> getCityById(Integer id) {
        return repo.findById(id);
    }

//    @Override
//    public City updateCity(City city) {
//        City existingCity = repo.findById(city.getId()).orElse(null);
//        if(existingCity == null){
//            throw new NoSuchElementException();
//        }
//        if(city.getName()!=null)
//            existingCity.setName(city.getName());
//        return repo.save(existingCity);
//    }

    @Override
    public Boolean deleteCity(Integer id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Integer countCity() {
        return Math.toIntExact(repo.count());
    }

}