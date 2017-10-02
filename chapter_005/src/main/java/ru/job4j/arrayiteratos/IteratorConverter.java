package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class for creating iterator convert.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class IteratorConverter {
    /**
     * The iterator for integer values from Iterator<Iterator<Integer>>.
     * @param it - transferred iterator.
     * @return Iterator.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> currentIt = null;

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Integer next() {
                if (this.currentIt == null || !currentIt.hasNext()) {
                    currentIt = it.next();
                }
                    return currentIt.next();
            }
        };

    }
}
