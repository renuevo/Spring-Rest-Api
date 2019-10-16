package com.github.renuevo.restapi.response;

import com.github.renuevo.restapi.dto.PersonDto;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

public class PersonDtoResponse extends ResourceSupport {

    @Getter
    private PersonDto personDto;

    public PersonDtoResponse(PersonDto personDto) {
        this.personDto = personDto;
    }

}
