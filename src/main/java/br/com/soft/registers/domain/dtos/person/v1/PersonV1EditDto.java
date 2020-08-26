package br.com.soft.registers.domain.dtos.person.v1;

import br.com.soft.registers.domain.dtos.person.PersonDto;

public class PersonV1EditDto extends PersonDto {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

