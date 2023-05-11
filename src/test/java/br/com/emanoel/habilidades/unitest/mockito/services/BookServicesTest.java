package br.com.emanoel.habilidades.unitest.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.emanoel.habilidades.BookRepositories.BookRepository;
import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.mock.book.MockBook;
import br.com.emanoel.habilidades.models.Book;
import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.services.BookServices;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
	MockBook input;

	@InjectMocks
	private BookServices service;

	@Mock
	BookRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		input = new MockBook();

		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreate() throws Exception {
		Book entity = input.mockEntity(1);

		Book persisted = entity;

		BookVO vo = input.mockVO(1);
		// vo.setId(1L);

		// when(repository.save(entity)).thenReturn(persisted);
//		lenient().when(repository.save(entity)).thenReturn(persisted);
//		var results = service.create(persisted);
//
//		assertNotNull(results);
//		assertNotNull(results.getId());
//		assertNotNull(results.getCategoria());
//		assertEquals("J. R. R. Tolkien", results.getAutor());
	}

	@Test
	void testFindById() throws Exception {
		List<Book> list = input.mockEntityList();
		when(repository.findAll()).thenReturn(list);
		var book = service.findAll();
		System.out.println(book.toString());
		assertNotNull(book);

	}
}
