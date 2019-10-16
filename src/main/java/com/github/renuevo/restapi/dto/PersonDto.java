package com.github.renuevo.restapi.dto;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.lang.reflect.Field;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    String id;      //key
    String name;    //이름

    @Min(1)
    Integer age;        //나이

    private static Set<String> defaultParamSet = Sets.newHashSet("defaultParamSet");

    //parameter all empty check
    public boolean getEmptyCheck() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (!defaultParamSet.contains(f.getName()))
                if (f.get(this) != null)
                    return false;
        }
        return true;
    }


}
