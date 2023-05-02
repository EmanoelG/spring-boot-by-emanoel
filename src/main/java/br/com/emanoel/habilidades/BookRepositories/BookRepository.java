package br.com.emanoel.habilidades.BookRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
