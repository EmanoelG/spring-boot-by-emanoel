package br.com.emanoel.habilidades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanoel.habilidades.data.v3.BookVO;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.models.Book;
import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.services.BookServices;
import br.com.emanoel.habilidades.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing Book")
public class BookController {

	@Autowired
	private BookServices service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Retorna todas os Livros ", description = "Retorna todas os Livros", responses = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class, allOf = BookVO.class))) }, description = "Sucess"),
			@ApiResponse(responseCode = "400", content = @Content, description = "Bad request"),
			@ApiResponse(responseCode = "401", content = @Content, description = "Unathorized"),
			@ApiResponse(responseCode = "500", content = @Content, description = "Internal Error")

	}

	)

	public List<BookVO> findAll() throws Exception {
		return service.findAll();
	}

	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Cadastra livro ", description = "Cadastra livro ", responses = {
			@ApiResponse(responseCode = "201", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class, allOf = BookVO.class))) }, description = "Sucess"),

			@ApiResponse(responseCode = "400", content = @Content, description = "Bad request"),
			@ApiResponse(responseCode = "401", content = @Content, description = "Unathorized"),
			@ApiResponse(responseCode = "500", content = @Content, description = "Internal Error")

	}

	)
	public ResponseEntity<BookVO> findCreate(@RequestBody BookVO book) throws Exception {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Busca livro por ID ", description = "Busca livro por ID ", responses = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookVO.class, allOf = BookVO.class))) }, description = "Sucess"),

			@ApiResponse(responseCode = "400", content = @Content, description = "Bad request"),
			@ApiResponse(responseCode = "401", content = @Content, description = "Unathorized"),
			@ApiResponse(responseCode = "500", content = @Content, description = "Internal Error")

	})
	public BookVO findById(@PathVariable("id") Long id) throws Exception {
		return service.findById(id);
	}

}
