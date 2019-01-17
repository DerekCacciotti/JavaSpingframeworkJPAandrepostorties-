package com.derekcacciotti.spring5webapp.repositories;


import com.derekcacciotti.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
