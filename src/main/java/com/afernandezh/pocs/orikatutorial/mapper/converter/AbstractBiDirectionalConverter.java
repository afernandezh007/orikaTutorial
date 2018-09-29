package com.afernandezh.pocs.orikatutorial.mapper.converter;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.converter.BidirectionalConverter;

/**
 * Overwrite the BidirectionalConverter to force to all child customconverters
 * to use the mandatory fillOtherFields methods
 *
 * @param <A>
 * @param <B>
 */
@Slf4j
public abstract class AbstractBiDirectionalConverter<A, B>
        extends BidirectionalConverter<A, B> {

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    protected abstract void fillOtherFieldsTo(A source, B target);

    /**
     * Aux method to fill the remaining fields required
     *
     * @param source
     * @param target
     */
    protected abstract void fillOtherFieldsFrom(B source, A target);
}
