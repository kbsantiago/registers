package br.com.soft.registers.services.interfaces;

import br.com.soft.registers.domain.dtos.person.PersonDto;
import br.com.soft.registers.domain.dtos.person.v1.PersonV1AddDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonService {
    boolean isValid(PersonDto personDto);
    PersonDto save(PersonDto personDto);
    boolean isDuplicatedDocument(PersonDto personDto);
    PersonDto getById(long id);
    List<PersonDto> getAll(int page);
    PersonDto update(PersonDto personDto);
    void delete(long id);
}
