package br.com.dio.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.personapi.dto.MessageResponseDTO;
import br.com.dio.personapi.dto.PersonDTO;
import br.com.dio.personapi.entity.Person;
import br.com.dio.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person savedPerson = personRepository.save(personDTO);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID: " + savedPerson.getId())
				.build();
	}
	

}
