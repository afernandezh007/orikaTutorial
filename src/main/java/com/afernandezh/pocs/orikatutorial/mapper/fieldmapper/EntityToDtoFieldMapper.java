package com.afernandezh.pocs.orikatutorial.mapper.fieldmapper;

import com.afernandezh.pocs.orikatutorial.dto.DummyDto;
import com.afernandezh.pocs.orikatutorial.model.DummyTable;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Custom Mapper for map AtriumDataView to AirlineDetail
 */
@Component("entityToDtoFieldMapper")
public class EntityToDtoFieldMapper extends ConfigurableMapper {

  @Override
  protected void configure(MapperFactory factory) {
    factory.classMap(DummyTable.class, DummyDto.class)
            .field("value","valueInDto")
            .field("id","idInDto")
            .register();
  }
}
