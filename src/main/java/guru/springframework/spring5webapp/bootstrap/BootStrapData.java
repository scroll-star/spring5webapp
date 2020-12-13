package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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
    public void run(String... args) {
        Address address = new Address("Osogovo str.", "12345", "Bulgaria", "Sofia", null);
        Publisher mitko = new Publisher("Mitko", "Dakov", address);
        publisherRepository.save(mitko);

        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "123123132");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(mitko);
        mitko.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(mitko);

        Author rod = new Author("Rod", "Johnson");
        Book jwe = new Book("JWE Development Without EJB", "12332131231");

        rod.getBooks().add(jwe);
        jwe.getAuthors().add(rod);
        jwe.setPublisher(mitko);
        mitko.getBooks().add(jwe);

        authorRepository.save(rod);
        bookRepository.save(jwe);
        publisherRepository.save(mitko);

        System.out.println("Started in bootstrap");
        System.out.println("Publisher number of books: " + mitko.getBooks().size());
    }
}
