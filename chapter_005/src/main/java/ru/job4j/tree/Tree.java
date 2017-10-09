package ru.job4j.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class for creating Tree.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 09.10.2017.
 * @param <E> type of element.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>, Comparator<E> {
    /**
     *Collection with all elements from Tree for Iterator.
     */
    private List<Node<E>> allElements = new LinkedList<>();
    /**
     * Node for storage values and collection of children.
     */
    private Node<E> root = null;
    /**
     * Index for Iterator.
     */
    private int index = 0;

    /**
     * Find parent Node by specified value and parent node.
     * @param parent - parent node value which need find.
     * @param node - node from which need starting search.
     * @return Node.
     */
    private Node<E> findParent(E parent, Node<E> node) {
        Node<E> result = null;
        if (compare(parent, node.value) == 0) {
            result = node;
        } else {
            List<Node<E>> children = node.getChildren();
            if (children.size() > 0) {
                for (Node<E> itm : children) {
                    result = findParent(parent, itm);
                    if (result != null) {
                        break;
                    }
                }
            }
        }
       return result;
    }

    /**
     * Add new element to Tree.
     * @param parent - parent.
     * @param child - child.
     * @return - boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (root == null) {
            root = new Node<>(parent);
            root.getChildren().add(new Node<>(child));
            allElements.add(root);
        } else {
            Node<E> parentNode = findParent(parent, root);
            Node<E> childNode = new Node<>(child);
            if (parentNode != null && findParent(child, parentNode) == null) {
                parentNode.getChildren().add(childNode);
                allElements.add(childNode);
                result = true;
            }
        }
        return result;
    }

    /**
     * Return patent child with indexValue.
     * @param parent - parent value.
     * @param indexValue - index of a child in the parent collection.
     * @return E - value.
     */
    public E getValue(E parent, int indexValue) {
        return findParent(parent, root).getChildren().get(indexValue).value;
    }

    /**
     * Iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return allElements.size() > index;
            }
            @Override
            public E next() {
               return allElements.get(index++).value;
            }
        };
    }

    /**
     * Comparator.
     * @param o1 - first object.
     * @param o2 - second object.
     * @return int.
     */
    @Override
    public int compare(E o1, E o2) {
        return (o1.equals(o2)) ? 0 : 1;
    }

    /**
     * Equals.
     * @param obj - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    /**
     * Hash code.
     * @return int.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Class for storage value and children.
     * @param <E> - type of element.
     */
    private class Node<E> {
        /**
         * Node children.
         */
        private List<Node<E>> children = new LinkedList<>();
        /**
         * Node value.
         */
        private E value;

        /**
         * Node constructor.
         * @param value - node value.
         */
        Node(E value) {
            this.value = value;
        }

        /**
         * Get children of this node.
         * @return List.
         */
        public List<Node<E>> getChildren() {
            return children;
        }
    }
}
