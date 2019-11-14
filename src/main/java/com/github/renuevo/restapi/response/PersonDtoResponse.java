package com.github.renuevo.restapi.response;

import com.github.renuevo.restapi.dto.PersonDto;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

/**
 * <pre>
 * @className : PersonDtoResponse
 * @author : Deokhwa.Kim
 * @since : 2019-11-14
 * </pre>
 */
public class PersonDtoResponse extends ResourceSupport {

    @Getter
    private PersonDto personDto;

    public PersonDtoResponse(PersonDto personDto) {
        this.personDto = personDto;
    }

}
