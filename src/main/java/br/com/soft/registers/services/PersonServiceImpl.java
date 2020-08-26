package br.com.soft.registers.services;

import br.com.soft.registers.domain.Person;
import br.com.soft.registers.domain.dtos.Message;
import br.com.soft.registers.domain.dtos.person.PersonDto;
import br.com.soft.registers.domain.dtos.person.v1.PersonV1AddDto;
import br.com.soft.registers.domain.dtos.person.v1.PersonV1EditDto;
import br.com.soft.registers.domain.valueObjects.Cpf;
import br.com.soft.registers.domain.valueObjects.Email;
import br.com.soft.registers.repository.PersonRepository;
import br.com.soft.registers.services.interfaces.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Transactional
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public boolean isValid(PersonDto personDto) {
        if(!personDto.getName().isEmpty() &&
            personDto.getDocument().isValid() &&
            personDto.getEmail().isValid() &&
            isValidFormatDate(personDto))
            return true;
        else {
            personDto.setResponseMessage(new Message("Person data sent is invalid."));
            return false;
        }
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        mapper.map(personDto, person);
        person.setBirthDate(LocalDate.parse(personDto.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        person.setDocument(personDto.getDocument().getCode());
        person.setEmail(personDto.getEmail().getAddress());
        person.setCreatedDate(LocalDateTime.now());
        person.setUpdatedDate(LocalDateTime.now());
        personRepository.save(person);
        mapper.map(person, personDto);
        return personDto;
    }

    @Override
    public boolean isDuplicatedDocument(PersonDto personDto) {
        Person person = new Person();
        mapper.map(personDto, person);
        person.setDocument(personDto.getDocument().getCode());
        Person p = personRepository.findByDocument(person.getDocument());
        return p != null ? true : false;
    }

    @Override
    public PersonDto getById(long id) {
        PersonDto personDto = new PersonV1EditDto();
        Person person = personRepository.getOne(id);
        mapper.map(person, personDto);
        personDto.setDocument(new Cpf(person.getDocument()));
        personDto.setEmail(new Email(person.getEmail()));
        return personDto;
    }

    @Override
    public List<PersonDto> getAll(int page) {
        Pageable pageable = PageRequest.of(page, 25);
        PersonDto personDto = null;
        List<PersonDto> people = new ArrayList<PersonDto>();
        for (Person person : personRepository.findAll(pageable)) {
            personDto = new PersonV1EditDto();
            mapper.map(person, personDto);
            personDto.setDocument(new Cpf(person.getDocument()));
            personDto.setEmail(new Email(person.getEmail()));
            people.add(personDto);
        }
        return people;
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        Person person = new Person();
        mapper.map(personDto, person);
        person.setBirthDate(LocalDate.parse(personDto.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        person.setDocument(personDto.getDocument().getCode());
        person.setEmail(personDto.getEmail().getAddress());
        person.setUpdatedDate(LocalDateTime.now());
        personRepository.save(person);
        mapper.map(person, personDto);
        return personDto;
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }

    private boolean isValidFormatDate(PersonDto personDto) {
        try {
            if(!personDto.getBirthDate().isEmpty()) {
                LocalDate.parse(personDto.getBirthDate(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }
}
