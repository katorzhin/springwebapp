package com.katorzhin.springframework.springwebapp.repositories;

import com.katorzhin.springframework.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
