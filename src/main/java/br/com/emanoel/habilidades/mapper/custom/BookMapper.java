package br.com.emanoel.habilidades.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.models.Book;

@Service
public class BookMapper {

	public BookVO convertEntityToVO(Book book) {
		BookVO vo = new BookVO();
		vo.setId(book.getId());
		vo.setAutor(book.getAutor());
		vo.setAnoPublicacao(book.getAnoPublicacao());
		vo.setCategoria(book.getCategoria());
		return vo;
	}

	public Book convertVoToEntity(BookVO book) {
		Book entity = new Book();
		entity.setId(book.getId());
		entity.setAutor(book.getAutor());
		entity.setCategoria(book.getCategoria());
		entity.setAnoPublicacao(book.getAnoPublicacao());
		// entity.setBirthDay(new Date());
		return entity;
	}

}
