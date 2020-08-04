package com.katorzhin.springframework.springwebapp.bootstrap;

import com.katorzhin.springframework.springwebapp.domain.Author;
import com.katorzhin.springframework.springwebapp.domain.Book;
import com.katorzhin.springframework.springwebapp.domain.Publisher;
import com.katorzhin.springframework.springwebapp.repositories.AuthorRepository;
import com.katorzhin.springframework.springwebapp.repositories.BookRepository;
import com.katorzhin.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("John");
        publisher.setAddressLine1("11 street");
        publisher.setCity("New York");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: "+publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book bookDec = new Book("Domain Driven Design","12346");
        eric.getBooks().add(bookDec);
        bookDec.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(bookDec);

        Author rod = new Author("Rod","jackson");
        Book book1 = new Book("Development EJB","122321");
        rod.getBooks().add(book1);
        book1.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book1);

        System.out.println("Number of books "+bookRepository.count());

    }
}
