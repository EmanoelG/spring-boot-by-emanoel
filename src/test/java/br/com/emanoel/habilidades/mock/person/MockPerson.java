package br.com.emanoel.habilidades.mock.person;

import java.util.ArrayList;
import java.util.List;

import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.models.Person;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(1);
	}

	public PersonVO mockVO() {
		return mockVO(1);
	}

	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}

	public List<PersonVO> mockVOList() {
		List<PersonVO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}

	public Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Addres Test");
		person.setFirstName("Emanoel");
		person.setGender("Male");
		person.setId(number.longValue());
		person.setLastName("Galvao");
		return person;
	}

	public PersonVO mockVO(Integer number) {
		PersonVO person = new PersonVO();
		person.setAddress("Addres Test");
		person.setFirstName("Emanoel");
		person.setGender("Male");
		person.setId(number.longValue());
		person.setLastName("Galvao");
		return person;
	}

}
