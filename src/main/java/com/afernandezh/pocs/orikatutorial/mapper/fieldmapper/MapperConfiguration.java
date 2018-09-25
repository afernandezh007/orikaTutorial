package com.afernandezh.pocs.orikatutorial.mapper.fieldmapper;

import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for all ConfigurableMappers
 *
 */
@Configuration
public class MapperConfiguration {

  //------------------------------------------------------------------------------------------------
  //mappers
  //------------------------------------------------------------------------------------------------
  @Autowired
  @Qualifier("entityToDtoFieldMapper")
  private EntityToDtoFieldMapper entityToDtoFieldMapper;

  /**
   * Method to configure each fieldmapper with the mapperFactory given by parameter
   * @param mapperFactory
   */
  public void registerConfigurableMappers(DefaultMapperFactory mapperFactory) {

    entityToDtoFieldMapper.configure(mapperFactory);
  }
}
