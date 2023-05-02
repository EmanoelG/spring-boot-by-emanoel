package br.com.emanoel.habilidades.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.BookRepositories.BookRepository;
import br.com.emanoel.habilidades.controllers.PersonController;
import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.exceptions.ResourceIsNullException;
import br.com.emanoel.habilidades.mapper.DozerMapper;
import br.com.emanoel.habilidades.models.Book;
import br.com.emanoel.habilidades.models.Person;

@Service
public class BookServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	BookRepository repository;

	public List<Book> findAll() {
		List<Book> bookS = repository.findAll();
		return bookS;
	}

	public Book create(Book book) throws Exception {
		if (book == null)
			throw new ResourceIsNullException();
		logger.info("Criando um livro !");
	
		repository.save(book);

		return book;
	}
}
