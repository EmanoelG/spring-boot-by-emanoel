package br.com.emanoel.habilidades.mock.book;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.models.Book;

public class MockBook {

	public Book mockEntity() {
		return mockEntity(1);
	}

	public BookVO mockVO() {
		return mockVO(1);
	}

	public List<Book> mockEntityList() {
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 14; i++) {
			books.add(mockEntity(i));
		}
		return books;
	}

	public List<BookVO> mockVOList() {
		List<BookVO> bookS = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			bookS.add(mockVO(i));
		}
		return bookS;
	}

	public Book mockEntity(Integer number) {
		Book books = new Book();
		long longValue = (long) number;
		books.setId(longValue);
		books.setTitulo("Senhor do aneis ");
		books.setAutor("J. R. R. Tolkien");
		books.setCategoria("épica fantasia");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate publicationDate = LocalDate.parse("29/07/1954", dtf);
		Instant instant = publicationDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		books.setAnoPublicacao(date);
		books.toString();
		return books;
	}

	public BookVO mockVO(Integer number) {
		BookVO bookVO = new BookVO();
		long longValue = (long) number;
		bookVO.setId(longValue);
		bookVO.setTitulo("Senhor do aneis ");
		bookVO.setAutor("J. R. R. Tolkien");
		bookVO.setCategoria("épica fantasia");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate publicationDate = LocalDate.parse("29/07/1954", dtf);
		Instant instant = publicationDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		bookVO.setAnoPublicacao(date);
		bookVO.toString();
		return bookVO;
	}
}
