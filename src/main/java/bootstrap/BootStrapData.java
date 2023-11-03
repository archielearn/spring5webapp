package bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Author;
import domain.Book;
import repositories.AuthorRepository;
import repositories.BookRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
	
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author eric=new Author("Eric","Evans");
		Book ddd= new Book("Domain Driven Design","121121") ;
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod=new Author("Rod","Johnson");
		Book noEJB= new Book("Java Development without EJB","21324564");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Botstrap Application started");
		System.out.println("No of Books - "+bookRepository.count());
		
	}

}
