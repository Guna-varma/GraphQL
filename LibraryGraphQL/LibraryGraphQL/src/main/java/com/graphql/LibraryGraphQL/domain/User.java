package com.graphql.LibraryGraphQL.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "dbuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer id;

    @Column(name = "username")
    private String name;

    @Column(name = "libId")
    private Integer libId;

    @ManyToOne
    @JoinColumn(name = "libId", insertable = false, updatable = false)
    @JsonIgnore
    private Library library;

}
