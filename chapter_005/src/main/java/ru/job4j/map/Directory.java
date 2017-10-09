package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating Directory.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 07.10.2017.
 * @param <K> - type of key.
 * @param <V> - type of value.
 */
public class Directory<K, V> implements Iterable {
    /**
     * Array when store Dir object which include K - key, V, value.
     */
    private Dir<K, V>[] table;

    /**
     * Counter of added elements.
     */
    private int size = 0;

    /**
     * Directory constructor. Initialize new array with the length = 16;
     */
    public Directory() {
        table = new Dir[16];
    }

    /**
     * Element position at iterator.
     */
    private int itrPosition = 0;

    /**
     * Directory constructor. Initialize new array with the specified size;
     * @param size - size of Directory.
     */
    public Directory(int size) {
        table = new Dir[size];
    }

    /**
     * Insert new Dir object with key and value.
     * @param key - key.
     * @param value - value.
     * @return boolean true - if the element was added, false - if wasn't added.
     */
    public boolean insert(K key, V value) {
        int position;
        boolean result = false;

        if (key == null) {
            return false;
        }

        if (size > table.length - 1) {
            resizeTable();
        }

        position = getPosition(key, table.length);

        if (table[position] != null && table[position].getDirKey().equals(key)) {
            table[position].setDirValue(value);
            result = true;
        } else if (table[position] != null && !table[position].getDirKey().equals(key)) {
            result = false;
        } else {
            table[position] = new Dir<>(key, value);
            size++;
            result = true;
        }
        return result;
    }

    /**
     * Return the value by specified key.
     * @param key - specified key.
     * @return V - value.
     */
    public V get(K key) {
        if (table[getPosition(key, table.length)].getDirValue() != null) {
            return table[getPosition(key, table.length)].getDirValue();
        } else {
            throw new NoSuchElementException();
        }

    }

    /**
     * Delete element from collection by specified key.
     * @param key - specified key.
     * @return boolean true - if element was deleted, false - if it wasn't deleted.
     */
    public boolean delete(K key) {
        boolean result = false;
        if (table[getPosition(key, table.length)] != null) {
            table[getPosition(key, table.length)] = null;
            result = true;
        }
        return result;
    }

    /**
     * Get position of element by specified key and specified array length.
     * @param key - specified key.
     * @param size - array size in which contains element with specified key.
     * @return int - element position.
     */
    private int getPosition(K key, int size) {
        return getHashKey(key.hashCode()) & (size - 1);
    }

    /**
     *Return hash key for key.
     * @param hashCode - hashCode of key.
     * @return int hashKey.
     */
    private int getHashKey(int hashCode) {
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    /**
     * Change array size when it full.
     */
    private void resizeTable() {
        Dir<K, V>[] newTable = new Dir[table.length * 2];
        transfer(newTable);
    }

    /**
     * Fill specified array elements from old table.
     * @param newTable - specified table.
     */
    private  void transfer(Dir<K, V>[] newTable) {
        int newPosition;
        for (Dir element : table) {
            newPosition = getPosition((K) element.getDirKey(), newTable.length);
            newTable[newPosition] = element;
        }
        table = newTable;
    }

    /**
     * Iterator.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {
                int nextIndex = itrPosition;
                while (table[nextIndex] == null && nextIndex < table.length - 1) {
                    nextIndex++;
                }

                return table[nextIndex] != null;
            }

            @Override
            public V next() {
               while (table[itrPosition] == null) {
                   itrPosition++;
               }
               return table[itrPosition++].getDirValue();
            }
        };
    }

    /**
     * Class for creating container for store key and value.
     * @param <K> - type of key.
     * @param <V> - type of value.
     */
    private class Dir<K, V> {
        /**
         * Key.
         */
        private K dirKey;
        /**
         * Value.
         */
        private V dirValue;

        /**
         * Dir constructor.
         * @param dirKey - key.
         * @param dirValue - value.
         */
        Dir(K dirKey, V dirValue) {
            this.dirKey = dirKey;
            this.dirValue = dirValue;
        }

        /**
         * Get key.
         * @return K - key.
         */
        public K getDirKey() {
            return dirKey;
        }

        /**
         * Get value.
         * @return value.
         */
        public V getDirValue() {
            return dirValue;
        }

        /**
         * Set new value.
         * @param dirValue - new value.
         */
        public void setDirValue(V dirValue) {
            this.dirValue = dirValue;
        }
    }
}
