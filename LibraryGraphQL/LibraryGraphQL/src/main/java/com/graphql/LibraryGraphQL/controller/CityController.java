package com.graphql.LibraryGraphQL.controller;

import com.graphql.LibraryGraphQL.domain.City;
import com.graphql.LibraryGraphQL.repository.CityRepo;
import com.graphql.LibraryGraphQL.service.CityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    private CityService service;

    @Autowired
    private CityRepo repo;

    @MutationMapping("addCity")
    public City addCity(@Argument CityInput cityInput) {
        City c = new City();
        c.setId(cityInput.getId());
        c.setName(cityInput.getName());
        return this.service.addCity(c);
    }

    @QueryMapping("getAllCity")
    public List<City> getAllCity() {
        return service.getAllCity();
    }

    @QueryMapping("getCityById")
    public Optional<City> getCityById(@Argument Integer id) {
        return service.getCityById(id);
    }

    @QueryMapping("countCity")
    public Integer countCity() {
        return Math.toIntExact(service.countCity());
    }

    @MutationMapping("updateCity")
    public City updateCity(@Argument Integer id, @Argument String name) {
        Optional<City> optionalCity = repo.findById(id);

        if (optionalCity.isPresent()) {
            City city = optionalCity.get();

            if (name != null)
                city.setName(name);

            repo.save(city);
            return city;
        }

        throw new NoSuchElementException();
    }

    @MutationMapping("deleteCity")
    public Boolean deleteCity(@Argument Integer id) {
        return service.deleteCity(id);
    }
}

@Getter
@Setter
class CityInput {
    private Integer id;
    private String name;
}


