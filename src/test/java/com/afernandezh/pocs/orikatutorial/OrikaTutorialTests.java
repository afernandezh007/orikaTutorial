package com.afernandezh.pocs.orikatutorial;

import com.afernandezh.pocs.orikatutorial.dto.DummyDto;
import com.afernandezh.pocs.orikatutorial.model.DummyTable;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.afernandezh.pocs.orikatutorial.mapper.converter.ConverterConfiguration.ENTITY_TO_DTO_CONVERTER;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaTutorialTests {

    @Autowired
    private MapperFactory mapperFactory;

    @Test
    public void testMap() {

        DummyTable entity = new DummyTable();
        entity.setId(100L);
        entity.setValue("test value");

        MapperFacade mapper = mapperFactory.getMapperFacade();
        DummyDto dto = mapper.convert(entity, DummyDto.class, ENTITY_TO_DTO_CONVERTER, null);

        log.info(dto.toString());
    }

}
