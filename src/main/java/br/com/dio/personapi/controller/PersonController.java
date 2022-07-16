package br.com.dio.personapi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.personapi.dto.MessageResponseDTO;
import br.com.dio.personapi.dto.PersonDTO;
import br.com.dio.personapi.entity.Person;
import br.com.dio.personapi.exception.PersonNotFoundException;
import br.com.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
	
	private PersonService personService;

//	@Autowired
//	public PersonController(PersonService personService) {
//		this.personService = personService;
//	}
	
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
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PersonDTO> peopleList() {
		return personService.peopleList();
	}
	
	@GetMapping("/{id}")
	public PersonDTO searchPerson(@PathVariable(value = "id") Long id) throws PersonNotFoundException {
		return personService.searchPerson(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable(value = "id") Long id) throws PersonNotFoundException {
		personService.deletePerson(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updatePerson(@PathVariable(value = "id") Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		return personService.updatePerson(id, personDTO);
	}	
	
}
