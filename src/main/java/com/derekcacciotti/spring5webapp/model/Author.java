package com.derekcacciotti.spring5webapp.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String FirstName;
    private String LastName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet();

    public Author()
    {

    }



    public Author(String firstName, String lastName)
    {
        this.FirstName = firstName;
        this.LastName = lastName;
    }



    public Author(String firstName, String lastName, Set<Book> books)
    {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.books = books;
    }


    public String getFirstName()
    {
        return FirstName;



    }


    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }


    public Set<Book> getBooks() {
        return books;
    }


    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", books=" + books +
                '}';
    }
}
