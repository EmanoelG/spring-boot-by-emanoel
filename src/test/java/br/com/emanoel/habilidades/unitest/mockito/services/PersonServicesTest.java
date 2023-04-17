package br.com.emanoel.habilidades.unitest.mockito.services;

import static org.junit.jupiter.api.Assertions.*;
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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.emanoel.habilidades.PersonRepositories.PersonRespository;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.exceptions.ResourceIsNullException;
import br.com.emanoel.habilidades.mock.person.MockPerson;
import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.services.PersonServices;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

	MockPerson input;

	@InjectMocks
	private PersonServices service;

	@Mock
	PersonRespository repository;

	@BeforeEach
	void setUp() throws Exception {
		input = new MockPerson();

		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() throws Exception {
		Person person = input.mockEntity(1);
		person.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		var results = service.findById(1L);
		assertNotNull(results);
		assertNotNull(results.getId());
		assertNotNull(results.getLinks());
		assertTrue(results.toString().contains("</persons/1>;rel=\"self\""));
		assertEquals("Emanoel", results.getFirstName());
	}

	@Test
	void testFindAll() {
		List<Person> list = input.mockEntityList();
		when(repository.findAll()).thenReturn(list);
		var people = service.findAll();

		assertNotNull(people);
		assertEquals(14, people.size());
		assertNotNull(people.get(5).getLinks());
	}

	@Test
	void testCreate() throws Exception {
		Person entity = input.mockEntity(1);

		Person persisted = entity;

		PersonVO vo = input.mockVO(1);
		// vo.setId(1L);

		// when(repository.save(entity)).thenReturn(persisted);
		lenient().when(repository.save(entity)).thenReturn(persisted);
		var results = service.create(vo);

		assertNotNull(results);
		assertNotNull(results.getId());
		assertNotNull(results.getLinks());
		assertTrue(results.toString().contains("</persons/1>;rel=\"self\""));
		assertEquals("Emanoel", results.getFirstName());
	}

	@Test
	void testCreateWithNull() throws Exception {
		Exception exception = assertThrows(ResourceIsNullException.class, () -> {
			var results = service.create(null);
		});
		String expectedMessage = "Não é permitido persistir um objeto nullo !";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void testUpdateWithNull() throws Exception {
		Exception exception = assertThrows(ResourceIsNullException.class, () -> {
			var results = service.update(null);
		});
		String expectedMessage = "Não é permitido persistir um objeto nullo !";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void testCreateV2() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() throws Exception {
		Person entity = input.mockEntity(1);

		Person persisted = entity;

		PersonVO vo = input.mockVO(1);
		// vo.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		lenient().when(repository.save(entity)).thenReturn(persisted);
		var results = service.update(vo);
		assertNotNull(results);
		assertNotNull(results.getId());
		assertNotNull(results.getLinks());
		assertTrue(results.toString().contains("</persons/1>;rel=\"self\""));
		assertEquals("Emanoel", results.getFirstName());
	}

	@Test
	void testDelete() throws Exception {
		Person entity = input.mockEntity(1);
		PersonVO vo = input.mockVO(1);

		Mockito.doNothing().when(repository).delete(entity);

	}

}
