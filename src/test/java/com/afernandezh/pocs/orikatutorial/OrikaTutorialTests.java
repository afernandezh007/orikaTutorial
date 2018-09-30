package com.afernandezh.pocs.orikatutorial;

import com.afernandezh.pocs.orikatutorial.dto.DummyDto;
import com.afernandezh.pocs.orikatutorial.mapper.OrikaMapperConfiguration;
import com.afernandezh.pocs.orikatutorial.model.DummyTable;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.afernandezh.pocs.orikatutorial.mapper.converter.ConverterConfiguration.DUMMY_CONVERTER;
import static com.afernandezh.pocs.orikatutorial.mapper.converter.ConverterConfiguration.DUMMY_CONVERTER_BIDIRECTIONAL;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OrikaMapperConfiguration.class)
public class OrikaTutorialTests {

    @Autowired
    private MapperFactory mapperFactory;

    private DummyTable createDummyData() {
        DummyTable entity = new DummyTable();
        entity.setId(100L);
        entity.setValue("test value");
        entity.setSameName("the same name in both classes");
        entity.setClob("Antonio#Fernández Hernández#31");
        entity.setEntityToDtoValue("entityToDtoOnly");
        return entity;
    }

    @Test
    public void testMapUniDirectional() {

        DummyTable entity = createDummyData();

        MapperFacade mapper = mapperFactory.getMapperFacade();
        DummyDto dto = mapper.convert(entity, DummyDto.class, DUMMY_CONVERTER, null);

        commonAssertsAboutDto(dto);
        log.info(dto.toString());
    }

    private void commonAssertsAboutDto(DummyDto dto) {
        assertNotNull("Expected not null value", dto);
        assertNotNull("Expected not null value", dto.getIdInDto());
        assertNotNull("Expected not null value", dto.getValueInDto());
        assertNotNull("Expected not null value", dto.getSameName());
        assertNotNull("Expected not null value", dto.getEntityToDtoValue());
        assertNull("Expected null value", dto.getDtoToEntityValue());
        assertNotNull("Expected not null value", dto.getAge());
        assertNotNull("Expected not null value", dto.getName());
        assertNotNull("Expected not null value", dto.getSurname());
    }

    @Test
    public void testMapBiDirectional() {

        DummyTable entity = createDummyData();

        MapperFacade mapper = mapperFactory.getMapperFacade();
        DummyDto dto = mapper.convert(entity, DummyDto.class, DUMMY_CONVERTER_BIDIRECTIONAL, null);

        commonAssertsAboutDto(dto);
        log.info(dto.toString());
        dto.setDtoToEntityValue("dtoToEntityOnly");

        DummyTable entityConverted = mapper.convert(dto, DummyTable.class, DUMMY_CONVERTER_BIDIRECTIONAL, null);

        commonAssertsAboutEntity(entityConverted);
        log.info(entityConverted.toString());
    }

    private void commonAssertsAboutEntity(DummyTable entity) {
        assertNotNull("Expected not null value", entity);
        assertNotNull("Expected not null value", entity.getId());
        assertNotNull("Expected not null value", entity.getValue());
        assertNotNull("Expected not null value", entity.getDtoToEntityValue());
        assertNull("Expected null value", entity.getEntityToDtoValue());
        assertNotNull("Expected not null value", entity.getClob());
    }

}
