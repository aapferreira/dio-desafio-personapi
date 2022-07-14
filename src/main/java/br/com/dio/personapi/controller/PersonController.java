package br.com.dio.personapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.personapi.dto.MessageResponseDTO;
import br.com.dio.personapi.dto.PersonDTO;
import br.com.dio.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
//	@PostMapping
//	public Person createPerson(@RequestBody Person person) {
//		Person savedPerson = personRepository.save(person);
//		return savedPerson;
//	}
	
//	@PostMapping
//	public MessageResponseDTO createPerson(@RequestBody Person person) {
//		Person savedPerson = personRepository.save(person);
//		return MessageResponseDTO
//				.builder()
//				.message("Created person with ID: " + savedPerson.getId())
//				.build();
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

}
