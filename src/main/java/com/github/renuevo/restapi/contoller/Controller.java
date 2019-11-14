package com.github.renuevo.restapi.contoller;


import com.github.renuevo.restapi.dto.PersonDto;
import com.github.renuevo.restapi.response.PersonDtoListResponse;
import com.github.renuevo.restapi.response.PersonDtoResponse;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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

    /**
     * <pre>
     *  @methodName : createDoc
     *  @author : Deokhwa.Kim
     *  @since : 2019-11-14 오후 6:33
     *  @summary :
     *  @param : [personDto, id]
     *  @return : org.springframework.http.ResponseEntity
     * </pre>
     */
    @PostMapping(value = "/doc/{id}", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
    public ResponseEntity createDoc(@RequestBody PersonDto personDto, @PathVariable String id) {
        //create URI info
        URI create = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(Controller.class).createDoc(personDto, id))
                .slash("{id}")
                .toUri();

        PersonDtoResponse personDtoResponse = new PersonDtoResponse(personDto);

        //Self Link
        personDtoResponse.add(ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(Controller.class).createDoc(personDto, id))
                .withSelfRel());

        return ResponseEntity.created(create).body(personDtoResponse);
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
    @GetMapping(value = "/search")
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


    @GetMapping(value = "/view/{id}")
    public ResponseEntity personView( @PathVariable @Valid @Min(3) Integer id) {
        PersonDtoResponse personDtoResponse = new PersonDtoResponse(new PersonDto());
        try {

        } catch (Exception e) {
            log.error("Api View Error {}", e.getMessage(), e);
            log.error("Error Id {}", id);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(personDtoResponse);
    }


}
