package br.com.emanoel.habilidades.PersonRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanoel.habilidades.models.Person;

public interface PersonRespository extends JpaRepository<Person,Long> {

}
