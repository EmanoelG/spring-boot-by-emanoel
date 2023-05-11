package br.com.emanoel.habilidades.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.BookRepositories.BookRepository;
import br.com.emanoel.habilidades.controllers.BookController;
import br.com.emanoel.habilidades.controllers.PersonController;
import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.exceptions.ResourceIsNullException;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.mapper.DozerMapper;
import br.com.emanoel.habilidades.models.Book;
import br.com.emanoel.habilidades.models.Person;

@Service
public class BookServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	BookRepository repository;

	public List<BookVO> findAll() {
//		List<Book> bookS = repository.findAll();
//		return bookS;

		List<BookVO> bookS = DozerMapper.parseListObject(repository.findAll(), BookVO.class);
		bookS.forEach(p -> {

			try {
				p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel().withRel("get"));
//				p.add(linkTo(methodOn(BookController.class).update(p)).withSelfRel().withRel("put"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return bookS;
	}

	public BookVO create(BookVO book) throws Exception {
		if (book == null)
			throw new ResourceIsNullException();
		logger.info("Criando um livro !");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getId())).withSelfRel());
		return vo;
	}

	public BookVO findById(Long id) throws Exception {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
		BookVO vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return vo;
	}
}
