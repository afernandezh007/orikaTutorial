package com.afernandezh.pocs.orikatutorial.mapper;

import com.afernandezh.pocs.orikatutorial.mapper.converter.ConverterConfiguration;
import com.afernandezh.pocs.orikatutorial.mapper.fieldmapper.MapperConfiguration;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Orika mappers and converters
 */
@Configuration
@ComponentScan(basePackages = "com.afernandezh.pocs.orikatutorial.*")
public class OrikaMapperConfiguration {

    @Autowired
    private ConverterConfiguration converterConfiguration;

    @Autowired
    private MapperConfiguration mapperConfiguration;

    /**
     * Build a DefaultMapperFactory adding the custom mappers and custom converters
     *
     * @return the fieldmapper factory
     */
    @Bean
    public MapperFactory mapperFactory() {

        //1. Build the mapperFactory
        DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        //2. Register all the configurable mappers
        mapperConfiguration.registerConfigurableMappers(mapperFactory);

        //3. Register all converters
        converterConfiguration.registerCustomConverters(mapperFactory);

        return mapperFactory;
    }

}
