package br.com.emanoel.habilidades.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanoel.habilidades.PersonRepositories.PersonRespository;
import br.com.emanoel.habilidades.data.vo.v1.PersonVO;
import br.com.emanoel.habilidades.data.vo.v2.PersonVOV2;
import br.com.emanoel.habilidades.exceptions.ResourceNotFoundException;
import br.com.emanoel.habilidades.mapper.DozerMapper;
import br.com.emanoel.habilidades.mapper.custom.PersonMapper;
import br.com.emanoel.habilidades.models.Person;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRespository repository;

	@Autowired
	PersonMapper mapper;

	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id !"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		logger.info("FindAll one PersonVO !");
		
		
		return DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO personvo) {
		logger.info("Create one PersonVO !");
		var entity = DozerMapper.parseObject(personvo, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 personvo2) {
		logger.info("Create one PersonVOV2 !");
		var entity = mapper.convertVoToEntity(personvo2);
		var vo = mapper.convertEntityToVO(repository.save(entity));
		return vo;
	}

	public PersonVO update(PersonVO PersonVO) {
		logger.info("update  PersonVO !");
		var entity = repository.findById(PersonVO.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		entity.setLastName(PersonVO.getLastName());
		entity.setAddress(PersonVO.getAddress());
		entity.setGender(PersonVO.getGender());
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Delete  PersonVO !");
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID !"));
		repository.delete(entity);
	}

}
