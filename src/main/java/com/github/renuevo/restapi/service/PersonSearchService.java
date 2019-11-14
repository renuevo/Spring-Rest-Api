package com.github.renuevo.restapi.service;

import com.github.renuevo.restapi.dto.PersonDto;
import com.github.renuevo.restapi.response.PersonDtoListResponse;
import com.github.renuevo.restapi.response.PersonDtoResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSearchService {

    /**
     * <pre>
     *  @methodName : personSearchList
     *  @author : Deokhwa.Kim
     *  @since : 2019-10-16 오후 5:53
     *  @summary : 인물 검색
     *  @param : [personDto]
     *  @return : com.github.renuevo.restapi.response.PersonDtoListResponse
     * </pre>
     */
    public PersonDtoListResponse personSearchList(PersonDto personDto) {

        List<PersonDtoResponse> personDtoResponseList = Lists.newArrayList();

        PersonDtoListResponse personDtoListResponse = new PersonDtoListResponse(personDtoResponseList); //return type

        /*
        personDtoListResponse.add( ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(Controller.class).searchDoc(personDto))
                .withRel("view"));
*/
        return personDtoListResponse;
    }
}
