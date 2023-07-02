package br.com.emanoel.habilidades.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.controllers.PersonController;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.mapper.DozerMapper;
import br.com.emanoel.habilidades.models.Users;
import br.com.emanoel.habilidades.repository.UserRepository;

@Service
public class UsersServices implements UserDetailsService {

	private Logger logger = Logger.getLogger(UsersServices.class.getName());

	@Autowired
	UserRepository repository;

	public Users findById(Long id) throws Exception {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
	
		return entity;
	}

	public UsersServices(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Finding one user by name " + username + "!");
		var user = repository.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found! ");
		}
	}

}
