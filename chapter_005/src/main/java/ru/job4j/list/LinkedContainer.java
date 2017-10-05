package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class for creating LinkedContainer.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.10.2017.
 * @param <E> - type of an element.
 */
public class LinkedContainer<E> implements SimpleContainer<E> {
    /**
     * The first element in collection.
     */
    private Node<E> firstNode = null;
    /**
     * The current element in collection.
     */
    private Node<E> currentNode = null;
    /**
     * Collection size.
     */
    private int size = 0;

    /**
     * Add new element to collection.
     * @param e - The element which need add.
     */
    @Override
    public void add(E e) {
        if (firstNode == null) {
            firstNode = new Node(null, null, e);
            currentNode = firstNode;
            size++;
        } else {
            currentNode.setNext(new Node(currentNode, null, e));
            currentNode = currentNode.getNext();
            size++;
        }
    }

    /**
     * Get element at specified index.
     * @param index - element index.
     * @return E - element.
     */
    @Override
    public E get(int index) {
        if (index < -1 || index > size - 1) {
            throw new NoSuchElementException();
        }
        Node<E> elem = firstNode;
        int nodeCount = 0;
        while (nodeCount != index) {
            if (elem.getNext() == null) {
                throw new NoSuchElementException();
            }
             elem = elem.getNext();
            nodeCount++;
        }

        return elem.getValue();
    }

    /**
     * Iterator for this collection.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private Node<E> thisNode = firstNode;
            @Override
            public boolean hasNext() {
                return thisNode != null;
            }

            @Override
            public E next() {
                E value = thisNode.getValue();
                thisNode = thisNode.getNext();
                return value;

            }
        };
    }

    /**
     * Class for creating instance of element.
     * @param <E> - type of element.
     */
   private class Node<E> {
        /**
         * Link to the next node element.
         */
        private Node next;
        /**
         * Link to the previous node element.
         */
        private Node prev;
        /**
         * The value which must stored in this collection.
         */
        private E value;

        /**
         * The node constructor.
         * @param prev - link to the previous node element.
         * @param next - link to the next node element.
         * @param value -the value which must stored in this collection.
         */
        private Node(Node prev, Node next, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        /**
         * Get the next node.
         * @return Node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Get the previous node.
         * @return Node.
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Set the next node.
         * @param next - the link to the next node.
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Set the previous node.
         * @param prev - the link to the previous node.
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }

        /**
         * Get value of this node.
         * @return E - value.
         */
        public E getValue() {
            return this.value;
        }
    }
}
