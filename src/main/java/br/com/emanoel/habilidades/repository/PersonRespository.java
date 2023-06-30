package br.com.emanoel.habilidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.models.Person;

@Repository
public interface PersonRespository extends JpaRepository<Person,Long> {

}
