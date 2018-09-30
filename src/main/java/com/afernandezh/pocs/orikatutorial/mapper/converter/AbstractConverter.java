package com.afernandezh.pocs.orikatutorial.mapper.converter;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomConverter;

/**
 * Overwrite the CustomConverter to force to all child customconverters
 * to use the mandatory fillOtherFields method
 *
 * @param <A>
 * @param <B>
 */
@Slf4j
public abstract class AbstractConverter<A, B> extends CustomConverter<A, B> {

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    protected abstract void fillOtherFields(A source, B target);
}
