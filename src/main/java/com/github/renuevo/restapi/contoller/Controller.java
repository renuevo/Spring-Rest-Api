package com.github.renuevo.restapi.contoller;


import com.github.renuevo.restapi.dto.PersonDto;
import com.github.renuevo.restapi.response.PersonDtoListResponse;
import com.github.renuevo.restapi.service.PersonSearchService;
import com.github.renuevo.restapi.validator.PersonDtoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class Controller {

    private final PersonDtoValidator personDtoValidator;
    private final PersonSearchService personSearchService;

    public Controller(PersonDtoValidator personDtoValidator, PersonSearchService personSearchService) {
        this.personDtoValidator = personDtoValidator;
        this.personSearchService = personSearchService;
    }

    @PostMapping(value = "/doc/", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
    public ResponseEntity createDoc(@RequestBody PersonDto personDto) {
        URI create = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(Controller.class).createDoc(personDto))
                .slash("{id}")
                .toUri();
        personDto.setId("10");
        return ResponseEntity.created(create).body(personDto);
    }

    /**
     * <pre>
     *  @methodName : searchDoc
     *  @author : Deokhwa.Kim
     *  @since : 2019-10-16 오후 5:53
     *  @summary : api search
     *  @param : [personDto, errors]
     *  @return : org.springframework.http.ResponseEntity
     * </pre>
     */
    @GetMapping(value = "search")
    public ResponseEntity searchDoc(@ModelAttribute @Valid PersonDto personDto, Errors errors) {
        PersonDtoListResponse personDtoListResponse;
        try {

            personDtoValidator.validate(personDto, errors);

            //valid check
            if (errors.hasErrors())
                return ResponseEntity.badRequest().body(errors.getAllErrors());

            //search
            personDtoListResponse = personSearchService.personSearchList(personDto);

            //self hateoas
            Link selfLink = ControllerLinkBuilder
                    .linkTo(ControllerLinkBuilder.methodOn(Controller.class).searchDoc(personDto, errors))
                    .withSelfRel();
            personDtoListResponse.add(selfLink);

        } catch (Exception e) {
            log.error("Api Search Error {}", e.getMessage(), e);
            log.error("Error Param {}", personDto);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(personDtoListResponse);
    }
}
