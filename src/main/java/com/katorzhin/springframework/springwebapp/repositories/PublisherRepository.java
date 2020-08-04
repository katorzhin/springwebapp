package com.katorzhin.springframework.springwebapp.repositories;

import com.katorzhin.springframework.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
