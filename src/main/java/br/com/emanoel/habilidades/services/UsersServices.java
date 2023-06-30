package br.com.emanoel.habilidades.services;

import org.springframework.hateoas.server.mvc.MvcLink;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.controllers.PersonController;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.data.vo.v2.PersonVOV2;
import br.com.emanoel.habilidades.exceptions.ResourceIsNullException;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.mapper.DozerMapper;
import br.com.emanoel.habilidades.mapper.custom.PersonMapper;
import br.com.emanoel.habilidades.models.Person;
import br.com.emanoel.habilidades.repository.PersonRespository;
import br.com.emanoel.habilidades.repository.UserRepository;

@Service
public class UsersServices implements UserDetailsService {

	private Logger logger = Logger.getLogger(UsersServices.class.getName());

	@Autowired
	UserRepository repository;

	public PersonVO findById(Long id) throws Exception {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
		PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
		vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return vo;
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
