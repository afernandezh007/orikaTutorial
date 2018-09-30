package com.afernandezh.pocs.orikatutorial.mapper.converter;

import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for all CustomConverters
 */
@Configuration
public class ConverterConfiguration {

    public static final String DUMMY_CONVERTER = "DummyConverter";
    public static final String DUMMY_CONVERTER_BIDIRECTIONAL = "DummyConverterBiDirectional";

    //----------------------------------------------------------------------------------
    //converters
    //----------------------------------------------------------------------------------
    @Autowired
    @Qualifier("dummyConverter")
    private DummyConverter dummyConverter;

    @Autowired
    @Qualifier("dummyBiDirectionalConverter")
    private DummyBiDirectionalConverter dummyBiDirectionalConverter;

    /**
     * Method to register each converter in the mapperFactory given by parameter
     *
     * @param mapperFactory
     */
    public void registerCustomConverters(DefaultMapperFactory mapperFactory) {
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(DUMMY_CONVERTER, dummyConverter);
        converterFactory.registerConverter(DUMMY_CONVERTER_BIDIRECTIONAL, dummyBiDirectionalConverter);
    }
}
