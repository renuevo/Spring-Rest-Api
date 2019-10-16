package com.github.renuevo.restapi.response;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public class PersonDtoListResponse extends ResourceSupport {

    @Getter
    List<PersonDtoResponse> personDtoResponsesList;

    public PersonDtoListResponse(List<PersonDtoResponse> personDtoResponsesList) {
        this.personDtoResponsesList = personDtoResponsesList;
    }


}
