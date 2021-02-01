import java.util.*;

/**
 * <p>
 *     <b><u>CSCU9Y4 - Practical 1</u></b>
 *     <br />
 *     <b><u>Queue.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 25.01.2021
 */

public class QueueWithLinkedList<K> {

    /**
     * A simple implementation of queue, generalised to any type of element.
     * elements is the name of the collection data items
     */
    private final List<K> elements;
    /* The <K> here is a type parameter. Note that it appears in the methods enqueuing and de-queueing */

    /**
     * Construct a new queue
     */
    public QueueWithLinkedList() {
        elements = new LinkedList<>();
    } // constructor

    /**
     * Gets the number of elements in the queue
     * @return the number of elements in the queue
     */
    public int howMany() {
        return elements.size();
    } // howMany

    /**
     * Add a new element to the end of the queue
     * @param k the object to enqueue
     */
    public void enqueue(K k) {
        elements.add(k);
    } // enqueue

    public K dequeue() {
        K firstInFirstOut;

        if (elements.size() > 0) {
            firstInFirstOut = elements.get(0);
            elements.remove(0);
        } else {
            firstInFirstOut = null;
        }

        return firstInFirstOut;
    } // dequeue

    @Override
    public String toString() {
        return "Queue{" + "elements = " + elements + "}";
    }

    public K getPosition(int index) {
        return elements.get(index);
    }
}
