package com.graphql.LibraryGraphQL.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "dbcity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityid")
    private Integer id;

    @Column(name = "cityname")
    private String name;

    @OneToMany(mappedBy = "cityId", cascade = CascadeType.ALL)
    private List<Library> libraryList;

}
