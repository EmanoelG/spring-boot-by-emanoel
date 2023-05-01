package br.com.emanoel.habilidades.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.data.vo.v2.PersonVOV2;
import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/persons/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	@Autowired
	private PersonServices service;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Busca pessoa por ID ", description = "Busca pessoa por ID", tags = { "People" }, responses = {
			@ApiResponse(responseCode = "200", content = {
			@ApiResponse(responseCode = "400", content = @Content, description = "Bad request"),
			@ApiResponse(responseCode = "401", content = @Content, description = "Unathorized"),
			@ApiResponse(responseCode = "500", content = @Content, description = "Internal Error")

	}

	)
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {
		return service.findById(id);
	}

	@PutMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		logger.info("Upadte user  !!!");
		return service.update(person);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Operation(summary = "Retorna todas as pessoas ", description = "Retorna todas as pessoas", tags = {
			"People" }, responses = { @ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PersonVO.class, allOf = Person.class))) }, description = "Sucess"),
					@ApiResponse(responseCode = "400", content = @Content, description = "Bad request"),
					@ApiResponse(responseCode = "401", content = @Content, description = "Unathorized"),
					@ApiResponse(responseCode = "500", content = @Content, description = "Internal Error")

	}

	)

	public List<PersonVO> findAll() throws Exception {

		return service.findAll();
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PersonVO> findCreate(@RequestBody PersonVO person) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(person));
	}

	@PostMapping(value = "/v2", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PersonVOV2> findCreateV2(@RequestBody PersonVOV2 V2) throws Exception {
		logger.info("V2  !!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createV2(V2));
	}

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> findDelete(@PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}