package com.graphql.LibraryGraphQL.controller;

import com.graphql.LibraryGraphQL.domain.Library;
import com.graphql.LibraryGraphQL.repository.LibraryRepo;
import com.graphql.LibraryGraphQL.service.LibraryService;
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
public class LibraryController {

    @Autowired
    private LibraryService service;

    @Autowired
    private LibraryRepo repo;

    @MutationMapping("addLibrary")
    public Library addLibrary(@Argument LibraryInput libraryInput) {
        Library l = new Library();
        l.setId(libraryInput.getId());
        l.setName(libraryInput.getName());
        l.setCityId(libraryInput.getCityId());
        return service.addLibrary(l);
    }

    @QueryMapping("getAllLibrary")
    public List<Library> getAllLibrary() {
        return service.getAllLibrary();
    }

    @QueryMapping("getLibraryById")
    public Optional<Library> getLibraryById(@Argument Integer id) {
        return service.getLibraryById(id);
    }

    @QueryMapping("countLibrary")
    public Integer countLibrary() {
        return service.countLibrary();
    }

    @MutationMapping("deleteLibrary")
    public Boolean deleteLibrary(@Argument Integer id) {
        return service.deleteLibrary(id);
    }

    @MutationMapping("updateLibrary")
    public Library updateLibrary(@Argument Integer id, @Argument String name) {

        Optional<Library> existingLibrary = repo.findById(id);

        if (existingLibrary.isPresent()) {
            Library library = existingLibrary.get();

            if (name != null)
                library.setName(name);
            repo.save(library);
            return library;
        }

        throw new NoSuchElementException();

    }


}

@Getter
@Setter
class LibraryInput {
    private Integer id;
    private String name;
    private Integer cityId;
}
