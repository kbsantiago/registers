package br.com.soft.registers.domain.dtos.person.v2;

import br.com.soft.registers.domain.dtos.address.AddressEditDto;
import br.com.soft.registers.domain.dtos.person.PersonDto;

public class PersonV2EditDto extends PersonDto {

    private long id;
    private AddressEditDto address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

