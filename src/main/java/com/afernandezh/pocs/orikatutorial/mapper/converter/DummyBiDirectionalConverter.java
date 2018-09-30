package com.afernandezh.pocs.orikatutorial.mapper.converter;

import com.afernandezh.pocs.orikatutorial.dto.DummyDto;
import com.afernandezh.pocs.orikatutorial.model.DummyTable;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

/**
 * Custom Converter for DummyTable <--> DummyDto
 */
@Slf4j
@Component("dummyBiDirectionalConverter")
public class DummyBiDirectionalConverter extends AbstractBiDirectionalConverter<DummyTable, DummyDto> {

    @Override
    public DummyDto convertTo(DummyTable source, Type<DummyDto> destinationType, MappingContext mappingContext) {
        //1. Instances a new target object
        DummyDto target = new DummyDto();

        //2. map only fields with same data but different name
        this.mapperFacade.map(source, target);
        //If you need to set info in the mappingContext you can use next statement to use it
        //this.mapperFacade.map(source, target, mappingContext);

        //3. Fill the remaining fields that need some operation to transform them from source dto
        fillOtherFieldsTo(source, target);

        return target;
    }

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    protected void fillOtherFieldsTo(DummyTable source, DummyDto target) {

        String blob = source.getClob();

        String[] split = blob.split("#");

        target.setName(split[0]);
        target.setSurname(split[1]);
        target.setAge(Integer.parseInt(split[2]));

    }

    @Override
    public DummyTable convertFrom(DummyDto source, Type<DummyTable> destinationType, MappingContext mappingContext) {
        //1. Instances a new target object
        DummyTable target = new DummyTable();

        //2. map only fields with same data but different name
        this.mapperFacade.map(source, target);
        //If you need to set info in the mappingContext you can use next statement to use it
        //this.mapperFacade.map(source, target, mappingContext);

        //3. Fill the remaining fields that need some operation to transform them from source dto
        fillOtherFieldsFrom(source, target);

        return target;
    }

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    protected void fillOtherFieldsFrom(DummyDto source, DummyTable target) {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(source.getName()).append("#")
                .append(source.getSurname()).append("#")
                .append(source.getAge());
        target.setClob(strBuilder.toString());
    }
}
