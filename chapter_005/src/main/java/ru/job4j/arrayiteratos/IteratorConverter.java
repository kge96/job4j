package ru.job4j.arrayiteratos;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
            private Iterator<Integer> integerIt = it.next();

            /**
             * Return true if next element form array is exist.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return integerIt.hasNext() || it.hasNext();
            }

            /**
             * Return next element.
             * @return Integer.
             */
            @Override
            public Integer next() {
                if (integerIt.hasNext()) {
                    return integerIt.next();
                } else if (!integerIt.hasNext() && it.hasNext()) {
                    integerIt = it.next();
                    return integerIt.next();

                } else {
                    throw new NoSuchElementException();
                }
            }
        };

    }
}
