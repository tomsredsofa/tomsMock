package de.doubleslash.coffee.domain;

import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;

/**
 * Created by IntelliJ IDEA.
 */
public class BecherPoolAlwaysThrows implements BecherPool {
    @Override
    public Becher leiheBecher(KaffeeGroesse kaffeeGroesse) throws KeinBecherInDieserGroesseException {
        throw new KeinBecherInDieserGroesseException();
    }
}
