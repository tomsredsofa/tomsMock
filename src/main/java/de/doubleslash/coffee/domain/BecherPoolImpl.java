package de.doubleslash.coffee.domain;

import de.doubleslash.coffee.exception.KeinBecherInDieserGroesseException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 */
public class BecherPoolImpl implements BecherPool {

    ConcurrentHashMap<KaffeeGroesse, Integer> inventory = new ConcurrentHashMap<>();

    public BecherPoolImpl(ConcurrentHashMap<KaffeeGroesse, Integer> inventory) {
        this.inventory = inventory;
    }

    @Override
    public Becher leiheBecher(KaffeeGroesse kaffeeGroesse) throws KeinBecherInDieserGroesseException {
        Integer oldValue;
        do {
            oldValue = inventory.get(kaffeeGroesse);
            if (oldValue.equals(0)) {
                throw new KeinBecherInDieserGroesseException();
            }
        }
        while (!inventory.replace(kaffeeGroesse, oldValue, oldValue - 1));
        return new Becher(kaffeeGroesse);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (KaffeeGroesse kaffeeGroesse : inventory.keySet()) {
            sb.append(kaffeeGroesse);
            sb.append(" / ");
            sb.append(inventory.get(kaffeeGroesse));
            sb.append("\n");
        }
        return "Becherpool : " + sb.toString();
    }
}
