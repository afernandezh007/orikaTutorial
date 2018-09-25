/**
 * Aviso legal
 * <p>
 * Toda la información contenida aquí es propiedad de Diners Club Spain,
 * S.A. y está protegida por la ley de propiedad intelectual. Cualquier
 * difusión o reproducción total o parcial, incluso para uso por
 * personal interno (empleado) o externo (proveedor), por cualquier
 * medio y bajo cualquier forma, está prohibida, salvo autorización
 * expresa por parte de Diners Club Spain, otorgada con carácter previo
 * y de forma escrita.
 * <p>
 * El uso o acceso permitido a dicha información no podrá entenderse
 * como cesión de ninguna clase de derecho de explotación sobre los
 * citados derechos de propiedad intelectual.
 */
package com.afernandezh.pocs.orikatutorial.mapper.converter;

import com.afernandezh.pocs.orikatutorial.dto.DummyDto;
import com.afernandezh.pocs.orikatutorial.model.DummyTable;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

/**
 * Custom Converter for AtriumDataView --> AirlineDetail
 */
@Slf4j
@Component("entityToDtoConverter")
public class EntityToDtoConverter extends CustomConverter<DummyTable, DummyDto> {

    @Override
    public DummyDto convert(DummyTable source, Type<? extends DummyDto> targetType, MappingContext mappingContext) {

        //1. Instances a new detail object
        DummyDto target = new DummyDto();

        //2. map only fields with same data but different name
        this.mapperFacade.map(source, target);

        //3. Fill the remaining fields that need some operation to transform them from source dto

        fillOtherFields(source, target);


        return target;
    }

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    private void fillOtherFields(DummyTable source, DummyDto target) {
    }
}
