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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.data.vo.v2.PersonVOV2;
import br.com.emanoel.habilidades.services.PersonServices;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	@Autowired
	private PersonServices service;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {
		return service.findById(id);
	}

	@GetMapping(produces ={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<PersonVO> findAll() throws Exception {
		return service.findAll();
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PersonVO> findCreate(@RequestBody PersonVO perso) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(perso));
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