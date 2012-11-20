package de.doubleslash.coffee.domain;

import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;

/**
 * Created by IntelliJ IDEA.
 */
public interface BecherPool {
    Becher leiheBecher(KaffeeGroesse kaffeeGroesse) throws KeinBecherInDieserGroesseException;
}
