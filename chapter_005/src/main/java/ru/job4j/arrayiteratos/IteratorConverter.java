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
     * @param itStoreage - transferred iterator.
     * @return Iterator.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> itStoreage) {
        return new Iterator<Integer>() {
            private Iterator<Integer> itInteger = itStoreage.next();

            /**
             * Return true if next element form array is exist.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return itInteger.hasNext() || itStoreage.hasNext();
            }

            /**
             * Return next element.
             * @return
             */
            @Override
            public Integer next() {
                if (itStoreage.hasNext() && itInteger.hasNext()) {
                    return itInteger.next();
                }
                if (!itInteger.hasNext() && itStoreage.hasNext()) {
                    itInteger = itStoreage.next();
                    return itInteger.next();
                }
                return null;
            }
        };

    }
}
