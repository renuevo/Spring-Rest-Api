package com.github.renuevo.restapi.contoller;


import com.github.renuevo.restapi.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class Controller {

    @PostMapping(value = "/doc/", produces = MediaTypes.HAL_JSON_UTF8_VALUE)
    public ResponseEntity createDoc(@RequestBody PersonDto personDto) {
        URI create = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder.methodOn(Controller.class).createDoc(personDto))
                .slash("{id}")
                .toUri();
        personDto.setId("10");
        return ResponseEntity.created(create).body(personDto);
    }

}
