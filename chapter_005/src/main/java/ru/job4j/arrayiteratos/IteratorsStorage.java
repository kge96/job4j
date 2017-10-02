package ru.job4j.arrayiteratos;

import java.util.Iterator;

/**
 * Class creating iterator storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 02.10.2017.
 */
public class IteratorsStorage implements Iterator<Iterator<Integer>> {
    /**
     * An element index in array.
     */
   private int index = 0;
    /**
     * The iterator array.
     */
   private Iterator<Integer>[] integerIts;

    /**
     * IteratorStorage constructor.
     * @param integersIts - transferred array of iterators.
     */
   public IteratorsStorage(Iterator<Integer>[] integersIts) {
       this.integerIts = integersIts;
   }

    /**
     * Check there is next element.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        return integerIts.length > index;
    }

    /**
     * Get nex element from array.
     * @return Iterator.
     */
    @Override
    public Iterator<Integer> next() {
        return integerIts[index++];
    }
}
