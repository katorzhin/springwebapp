package com.katorzhin.springframework.springwebapp.repositories;

import com.katorzhin.springframework.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
