package com.afernandezh.pocs.orikatutorial.mapper.converter;

import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for all CustomConverters
 *
 * @author atSistemas
 *
 */
@Configuration
public class ConverterConfiguration {

  public static final String ENTITY_TO_DTO_CONVERTER = "EntityToDtoConverter";

  //------------------------------------------------------------------------------------------------
  //converters
  //------------------------------------------------------------------------------------------------
  @Autowired
  @Qualifier("entityToDtoConverter")
  private EntityToDtoConverter entityToDtoConverter;

  /**
   * Method to register each converter in the mapperFactory given by parameter
   * @param mapperFactory
   */
  public void registerCustomConverters(DefaultMapperFactory mapperFactory) {
    ConverterFactory converterFactory = mapperFactory.getConverterFactory();
    converterFactory.registerConverter(ENTITY_TO_DTO_CONVERTER, entityToDtoConverter);
  }
}
