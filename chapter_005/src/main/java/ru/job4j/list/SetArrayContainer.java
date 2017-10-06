package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating SetArrayContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 * @param <E> - element type.
 */
public class SetArrayContainer<E> implements SimpleContainer<E> {
    /**
     * Elements array.
     */
    private E[] array;
    /**
     * Current element position.
     */
    private int position = 0;

    /**
     * Constructor. Create new array with default length = 5;
     */
    public SetArrayContainer() {
      this.array = (E[]) new Object[5];
    }

    /**
     * Constructor. Create new array with specified length.
     * @param size - size of a new array.
     */
    public SetArrayContainer(int size) {
      this.array = (E[]) new Object[size];
    }

    /**
     * Add new element in array.
     * @param e - The element which need added.
     */
    @Override
    public void add(E e) {
      boolean present = false;
      if (position > array.length - 1) {
          array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
      }
      for (E elem : array) {
          if (elem != null && elem.equals(e)) {
              present = true;
              break;
            }
        }
        if (!present) {
            array[position++] = e;
        }
    }

    /**
     * Get element with specified index.
     * @param index - element index.
     * @return E.
     */
    @Override
    public E get(int index) {
      if (index > position) {
          throw new NoSuchElementException();
      }
        return array[index];
    }

    /**
     * Array iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int thisPosition = 0;
            @Override
            public boolean hasNext() {
                return array.length > position;
            }
            @Override
            public E next() {
                return array[thisPosition++];
            }
        };
    }
}
