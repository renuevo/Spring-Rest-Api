package com.github.renuevo.restapi.response;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * <pre>
 * @className : PersonDtoListResponse
 * @author : Deokhwa.Kim
 * @since : 2019-11-14
 * </pre>
 */
public class PersonDtoListResponse extends ResourceSupport {

    @Getter
    List<PersonDtoResponse> personDtoResponsesList;

    public PersonDtoListResponse(List<PersonDtoResponse> personDtoResponsesList) {
        this.personDtoResponsesList = personDtoResponsesList;
    }


}
