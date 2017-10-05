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
            private Iterator<Integer> currentIt = it.next();

            /**
             * Return true if next element form array is exist.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return currentIt.hasNext();
            }

            /**
             * Return next element.
             * @return
             */
            @Override
            public Integer next() {
                if (it.hasNext() && currentIt.hasNext()) {
                    return currentIt.next();
                }
                if (!currentIt.hasNext() && it.hasNext()) {
                    currentIt = it.next();
                    return currentIt.next();
                }
                return null;
            }
        };

    }
}
