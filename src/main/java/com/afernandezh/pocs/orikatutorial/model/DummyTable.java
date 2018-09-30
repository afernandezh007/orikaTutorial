package com.afernandezh.pocs.orikatutorial.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class DummyTable {

    private Long id;

    private String value;

    private String sameName;

    private String dtoToEntityValue;

    private String entityToDtoValue;

    private String clob;
}
