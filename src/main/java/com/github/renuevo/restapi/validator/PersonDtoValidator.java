package com.github.renuevo.restapi.validator;

import com.github.renuevo.restapi.dto.PersonDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class PersonDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /**
     * <pre>
     *  @methodName : validate
     *  @author : Deokhwa.Kim
     *  @since : 2019-10-16 오후 5:08
     *  @summary : PersonDto Validate
     *  @param : [target, errors]
     *  @return : void
     * </pre>
     */
    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof PersonDto) {
            PersonDto personDto = (PersonDto) target;
            try {
                if (personDto.getEmptyCheck())
                    errors.reject("Parameter", "All Parameter Empty");
            } catch (Exception e) {
                errors.reject("Validator", e.getMessage());
            }
        } else {
            errors.reject("Parameter", "Bad Parameter");
        }
    }
}
