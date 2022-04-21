import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
    @Test
    public void PriorityQueueSizeTest() {
        PriorityQueue<Integer> a = new PriorityQueue<>(4);
        a.offer(2);
        a.offer(5);
        a.offer(3);
        a.offer(7);

        final int expectedSize = 4;
        final int actualSize = a.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void PriorityQueueAddGetTest() {
        PriorityQueue<Integer> a = new PriorityQueue<>(2);
        a.offer(2);
        a.offer(3);

        final int expectedCount = 2;
        final int actualCount = a.get(1);
        Assert.assertEquals(expectedCount, actualCount);
    }



    @Test
    public void ZeroSizeMPriorityQueueTest() {
        PriorityQueue<Integer> a = new PriorityQueue<>(0);
        final int expectedSize = 0;
        final int actualSize = a.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void EmptyPriorityQueueTest() {
        PriorityQueue<Integer> a = new PriorityQueue<>(1);
        Assert.assertTrue(a.isEmpty());
    }

    @Test
    public void NotEmptyPriorityQueueTest() {
        PriorityQueue<Integer> a = new  PriorityQueue<>(1);
        a.offer(2);
        Assert.assertFalse(a.isEmpty());
    }



}