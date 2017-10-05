package ru.job4j.list;

/**
 * Class for creating CyclicalDetector.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.10.2017.
 * @param <T> - value type.
 */
public class CyclicalDetector<T> {
    /**
     * Check cyclical Node.
     * @param first - start element.
     * @return boolean.
     */
    public boolean hasCycle(Node<T> first) {
        Node<T> next = first.getNext();
        while (next.getNext() != null) {
            if (next.getNext().equals(first.getNext())) {
                return true;
            } else {
                next = next.getNext();
            }
        }
        return false;
    }
}
