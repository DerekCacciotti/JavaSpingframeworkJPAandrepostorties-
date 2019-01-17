package com.derekcacciotti.spring5webapp.boostrap;


import com.derekcacciotti.spring5webapp.repositories.AuthorRepository;
import com.derekcacciotti.spring5webapp.repositories.BookRepository;
import com.derekcacciotti.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import com.derekcacciotti.spring5webapp.model.*;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData()
    {

        Publisher publisher = new Publisher();
        publisher.setName("foo");


        publisherRepository.save(publisher);


        Author eric = new Author("eric","evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author a2 = new Author("derek","cacciotti");
        Book b1 = new Book("Derek's cool book", "12345", publisher);
        a2.getBooks().add(b1);
        b1.getAuthors().add(a2);

        authorRepository.save(a2);
        bookRepository.save(b1);
    }
}
