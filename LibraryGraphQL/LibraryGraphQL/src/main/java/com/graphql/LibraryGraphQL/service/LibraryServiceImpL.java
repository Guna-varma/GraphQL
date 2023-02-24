package com.graphql.LibraryGraphQL.service;

import com.graphql.LibraryGraphQL.domain.Library;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;
import java.util.Optional;

public interface LibraryServiceImpL {

    Library addLibrary(Library library);

    List<Library> getAllLibrary();

    Optional<Library> getLibraryById(Integer id);

    Integer countLibrary();

    Boolean deleteLibrary(Integer id);
}
