package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.Library;
import com.graphql.LibraryGraphQL.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements LibraryServiceImpL{

    @Autowired
    private LibraryRepo repo;

    @Override
    public Library addLibrary(Library lib) {
        return repo.save(lib);
    }


    @Override
    public List<Library> getAllLibrary() {
        return repo.findAll();
    }

    @Override
    public Optional<Library> getLibraryById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Integer countLibrary() {
        return Math.toIntExact(repo.count());
    }

    @Override
    public Boolean deleteLibrary(Integer id) {
        repo.deleteById(id);
        return true;
    }
}
