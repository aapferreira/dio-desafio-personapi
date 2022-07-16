package br.com.dio.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.dio.personapi.dto.PersonDTO;
import br.com.dio.personapi.entity.Person;

@Mapper
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "yyyy-MM-dd")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);

}
