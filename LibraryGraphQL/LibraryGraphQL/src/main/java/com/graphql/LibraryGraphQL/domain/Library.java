package com.graphql.LibraryGraphQL.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "dblibrary")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libid")
    private Integer id;

    @Column(name = "libname")
    private String name;

    @Column(name = "cityId")
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "cityId", insertable = false,updatable = false)
//    @JsonIgnore
    private City city;


    @OneToMany(mappedBy = "libId",cascade = CascadeType.ALL)
    private List<User> userList;

}
