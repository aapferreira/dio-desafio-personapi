package br.com.dio.personapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.personapi.dto.MessageResponseDTO;
import br.com.dio.personapi.dto.PersonDTO;
import br.com.dio.personapi.entity.Person;
import br.com.dio.personapi.exception.PersonNotFoundException;
import br.com.dio.personapi.mapper.PersonMapper;
import br.com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

//	@Autowired
//	public PersonService(PersonRepository personRepository) {
//		super();
//		this.personRepository = personRepository;
//	}
	
//	public MessageResponseDTO createPerson(PersonDTO personDTO) {
//		
//		Person personToSave = new Person();
//		
//		//a abordagem abaixo funciona mas não lida com tipos de dados diferentes
//		//no dto e no model, como é o caso de birthDate: String para Date 
//		BeanUtils.copyProperties(personDTO, personToSave);
//		
//		Person savedPerson = personRepository.save(personToSave);
//		return MessageResponseDTO
//				.builder()
//				.message("Created person with ID: " + savedPerson.getId())
//				.build();
//	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return message("Saved person with ID: " + savedPerson.getId());
	}
	
	public List<PersonDTO> peopleList() {
		List<Person> allPeople = personRepository.findAll(); 
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

//	public PersonDTO searchPerson(Long id) throws PersonNotFoundException {
//		Optional<Person> personOptional = personRepository.findById(id);
//		if (personOptional.isEmpty()) {
//			throw new PersonNotFoundException(id);
//		}
//		return personMapper.toDTO(personOptional.get());
//	}
	
	public PersonDTO searchPerson(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}
	
	public void deletePerson(Long id) throws PersonNotFoundException {
		verifyIfExists(id);		
		personRepository.deleteById(id);
	}
	
	public MessageResponseDTO updatePerson(Long id, @Valid PersonDTO personDTO) throws PersonNotFoundException {
		
		verifyIfExists(id);
		
		Person personToUpdate = personMapper.toModel(personDTO);
		
		Person updatedPerson = personRepository.save(personToUpdate);
		return message("Update person with ID: " + updatedPerson.getId());
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponseDTO message(String msg) {
		return MessageResponseDTO
				.builder()
				.message(msg)
				.build();
	}
	
}
