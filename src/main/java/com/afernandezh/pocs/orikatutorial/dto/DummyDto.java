package com.afernandezh.pocs.orikatutorial.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class DummyDto {

    private Long idInDto;

    private String valueInDto;

    private String sameName;

    private String dtoToEntityValue;

    private String entityToDtoValue;

    private String name;

    private String surname;

    private Integer age;
}
