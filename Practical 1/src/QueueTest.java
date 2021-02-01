import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class QueueTest {
    private Queue qq;
    private QueueWithLinkedList qql;

    /**
     * Simple version. Instantiate with integers for testing
     */
    @Before
    public void setUp() {
        this.qq = new Queue<Integer>();
        this.qql = new QueueWithLinkedList<Integer>();
    }

    @Testq
    public void testInitialState() {
        Assert.assertEquals("This queue is not empty: ", 0, this.qq.howMany());
        Assert.assertEquals("This queue is not empty: ", 0, this.qql.howMany());
    }

    @Test
    public void testAddElement() {
        int[] elements = { 2, 4, 6, 8, 10 };

        // Load the data
        for (int element : elements) {
            this.qq.enqueue(element);
            this.qql.enqueue(element);
        }

        // Test the data
        Assert.assertNotEquals("This queue is empty: ", 0, this.qq.howMany());
        Assert.assertNotEquals("This queue is empty: ", 0, this.qql.howMany());

        Assert.assertEquals("The first position is incorrect: ", 2, this.qq.getPosition(0));
        Assert.assertEquals("The first position is incorrect: ", 2, this.qql.getPosition(0));

        Assert.assertEquals("The last position is incorrect: ", 10, this.qq.getPosition(this.qq.howMany() - 1));
        Assert.assertEquals("The last position is incorrect: ", 10, this.qq.getPosition(this.qql.howMany() - 1));
    }

    /**
     * If this test is ran independently to the other tests, uncomment the "loading" code below. Otherwise,
     * the loaded data from the testAddElement should carry over to this test
     */
    @Test
    public void testHowMany() {
        int[] elements = { 2, 4, 6, 8, 10 };

        // Load the data
        for (int element : elements) {
            this.qq.enqueue(element);
            this.qql.enqueue(element);
        }

        Assert.assertNotEquals("This queue is empty: ", 0, this.qq.howMany());
        Assert.assertNotEquals("This queue is empty: ", 0, this.qql.howMany());

        Assert.assertEquals("Ths queue does not have a sufficient number of elements: ", 7, this.qq.howMany());
        Assert.assertEquals("Ths queue does not have a sufficient number of elements: ", 7, this.qql.howMany());
    }

    /**
     * If this test is ran independently to the other tests, uncomment the "loading" code below. Otherwise,
     * the loaded data from the testAddElement should carry over to this test
     */
    @Test
    public void testGetElement() {
        int[] elements = { 2, 4, 6, 8, 10 };

        // Load the data
        for (int element : elements) {
            this.qq.enqueue(element);
            this.qql.enqueue(element);
        }

        Assert.assertNotEquals("This queue is empty: ", null, this.qq.dequeue());
        Assert.assertNotEquals("This queue is empty: ", null, this.qql.dequeue());

        // The first element will change as the de-queue method is called
        Assert.assertEquals("The first element was not de-queued properly, or the queue is empty: ", 1, this.qq.dequeue());
        Assert.assertEquals("The first element was not de-queued properly, or the queue is empty: ", 1, this.qql.dequeue());
    }

    @Test
    public void testTimings() {
        System.out.println("TESTING TIMINGS...");

        final int UPPER_LIMIT = 100000;
        final int LOWER_LIMIT = 0;

        long start = System.currentTimeMillis();
        System.out.println("Enqueuing has begun...");

        for (int i = LOWER_LIMIT; i < UPPER_LIMIT; i++) {
            int randomNumber = 1 + (int)(Math.random() * ((50 - 1) + 1));
            this.qq.enqueue(randomNumber);
            this.qql.enqueue(randomNumber);
        }

        System.out.println("Enqueuing has finished.\nDe-queuing has begun...");
        IntStream.range(LOWER_LIMIT, UPPER_LIMIT).forEach(i -> this.qq.dequeue());
        IntStream.range(LOWER_LIMIT, UPPER_LIMIT).forEach(i -> this.qql.dequeue());
        System.out.println("De-queuing has finished");

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        System.out.printf("It took %s ms for the operation to complete%n", elapsedTime);
    }
}