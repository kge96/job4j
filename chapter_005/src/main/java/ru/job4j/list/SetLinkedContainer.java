package ru.job4j.list;

/**
 * Class for creating SetLinkedContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 06.10.2017.
 * @param <E> - type of element.
 */
public class SetLinkedContainer<E> extends LinkedContainer<E> {
    /**
     * Array with elements sorted by hashCode.
     */
    private Object[] elements = new Object[1];
    /**
     * Count of added elements.
     */
    private int elementCounter = 0;

    /**
     * Add new element to collection if there isn't in it.
     * @param element - element.
     */
    @Override
    public void add(E element) {
        if (!super.contains(element)) {
            super.add(element);
        }
    }

    /**
     * Addition element with checking by hashCode.
     * @param element - added element.
     */
    public void fastAdd(E element) {
        if (this.elements.length - 1 < elementCounter) {
            resizeTable();
        }
        int index = getPosition(element, elements.length);
        Node<E> newNode = new Node<>(element);

        if (elements[index] != null) {
            Node<E> node = (Node<E>) elements[index];
            E nodeValue = node.value;

            if (!nodeValue.equals(element)) {
                Node<E> currentE =  (Node<E>) elements[index];
                while (currentE.next != null) {
                    currentE = currentE.next;
                    if (currentE.value.equals(element)) {
                        currentE = null;
                        break;
                    }
                }
                if (currentE != null) {
                    currentE.next = newNode;
                    super.add(element);
                    elementCounter++;
                }
            } else {
                return;
            }
        } else {
            elements[index] = newNode;
            elementCounter++;
            super.add(element);
        }
    }

    /**
     * Get position of element by specified key and specified array length.
     * @param key - specified key.
     * @param size - array size in which contains element with specified key.
     * @return int - element position.
     */
    private int getPosition(E key, int size) {
        size = (size == 1) ? 1 : size - 1;
        return getHashKey(key.hashCode()) % (size);
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
        Object[] newTable = new Object[elements.length * 2];
        transfer(newTable);
    }

    /**
     * Transfer old array with elements to new array.
     * @param newTable - new table.
     */
    private  void transfer(Object[] newTable) {
        int newPosition;
        for (Object element : elements) {
            Node<E> node = (Node<E>) element;
            if (node == null) {
                continue;
            }
            if (node.next != null) {
                while (node.next != null) {
                    node = node.next;
                    newPosition = getPosition(node.value, newTable.length);
                    newTable[newPosition] = element;
                }
            } else {
                newPosition = getPosition(node.value, newTable.length);
                newTable[newPosition] = element;
            }
        }
        elements = newTable;
    }

    /**
     * Node for hashTable.
     * @param <E> - type of elements.
     */
    private class Node<E> {
        /**
         * Node value.
         */
        private E value;
        /**
         * Next node if when added element was conflict.
         */
        private Node<E> next = null;

        /**
         * Constructor.
         * @param value - node value.
         */
        Node(E value) {
            this.value = value;
        }

        /**
         * Set nex node.
         * @param node - node.
         */
        public void setNext(Node<E> node) {
            this.next = node;
        }
    }
}
