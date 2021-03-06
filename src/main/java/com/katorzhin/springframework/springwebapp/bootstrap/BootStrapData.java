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
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("OOO MEGA Publishers");
//        publisher.setAddressLine1("11 street");
        publisher.setCity("New York");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book bookDec = new Book("Domain Driven Design", "12346");
        eric.getBooks().add(bookDec);
        bookDec.getAuthors().add(eric);

        bookDec.setPublisher(publisher);
        publisher.getBooks().add(bookDec);

        authorRepository.save(eric);
        bookRepository.save(bookDec);
        publisherRepository.save(publisher);

        Author authorSecond = new Author("Rod", "jackson");
        Book bookSecond = new Book("Development EJB", "122321");

        Author alex = new Author("Alex", "Katorzhin");
        alex.getBooks().add(bookDec);
        bookDec.getAuthors().add(alex);

        authorSecond.getBooks().add(bookSecond);
        bookSecond.getAuthors().add(authorSecond);

        bookSecond.setPublisher(publisher);
        publisher.getBooks().add(bookSecond);

        authorRepository.save(authorSecond);
        bookRepository.save(bookSecond);
        publisherRepository.save(publisher);
        authorRepository.save(alex);
        bookRepository.save(bookDec);


        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
