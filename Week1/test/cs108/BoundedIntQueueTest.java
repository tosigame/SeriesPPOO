package cs108;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BoundedIntQueueTest {


    @Test
    void capacity() {
        assertEquals(new BoundedIntQueueBuggy(5).capacity(),5);

    }

    @Test
    void size() {
        BoundedIntQueue bounded = new BoundedIntQueueBuggy(2);
        bounded.addLast(2);
        bounded.addLast(7);

        assertEquals(bounded.size(),2);

    }

    @Test
    void isEmpty() {
        BoundedIntQueue bounded = new BoundedIntQueueBuggy(3);
        assertTrue(bounded.isEmpty());

    }

    @Test
    void isFull() {
        BoundedIntQueueBuggy BoundedIntQueueBuggy=new BoundedIntQueueBuggy(2);

        BoundedIntQueueBuggy.addLast(2);
        BoundedIntQueueBuggy.addLast(2);
        assertTrue(BoundedIntQueueBuggy.isFull());
    }

    @Test
    public void constructingAQueueWithNegativeCapacityFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueBuggy(-1);
        });
    }

    @Test
    public void capacityIsEqualToWhatWasAsked() {
        for (int c = 0; c <= 100; ++c)
            assertEquals(c,  new BoundedIntQueueBuggy(c).capacity());
    }

    @Test
    public void initialSizeIsZero() {
        assertEquals(0,  new BoundedIntQueueBuggy(10).size());
    }

    @Test
    public void addingToQueueWithZeroCapacityFails() {
        BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(0);
        assertThrows(IllegalStateException.class, () -> {
            q.addLast(0);
        });
    }

    @Test
    public void addingToFullQueueFails() {
        BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(2);
        q.addLast(1);
        q.addLast(2);
        assertThrows(IllegalStateException.class, () -> {
            q.addLast(3);
        });
    }

    @Test
    public void removingFromEmptyQueueFails() {
        BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(10);
        assertThrows(IllegalStateException.class, () -> {
            q.removeFirst();
        });
    }

    @Test
    public void sizeReturnsCorrectValue() {
        int capacity = 100;
        BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(capacity);
        for (int i = 0; i < capacity; ++i) {
            assertEquals(i, q.size());
            q.addLast(i);
        }
    }

    @Test
    public void isEmptyIsInitiallyTrue() {
        for (int capacity = 0; capacity < 100; ++capacity) {
            BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(capacity);
            assertTrue(q.isEmpty());
        }
    }

    @Test
    public void isFullIsInitiallyFalse() {
        for (int capacity = 1; capacity < 100; ++capacity) {
            BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(capacity);
            assertFalse(q.isFull());
        }
    }

    @Test
    public void hasFirstInFirstOutBehavior() {
        Random rng = new Random();
        BoundedIntQueueBuggy q = new BoundedIntQueueBuggy(20);
        int nextToAdd = 0;
        int nextToRemove = 0;
        for (int i = 0; i < 1000; ++i) {
            if (q.isEmpty() || (!q.isFull() && rng.nextInt(3) != 0))
                q.addLast(nextToAdd++);
            else
                assertEquals(nextToRemove++, q.removeFirst());
        }
        while (!q.isEmpty())
            assertEquals(nextToRemove++, q.removeFirst());
        assertEquals(nextToAdd, nextToRemove);
    }
    @Test
    void addLast() {
        BoundedIntQueueBuggy BoundedIntQueueBuggy=new BoundedIntQueueBuggy(5);
        BoundedIntQueueBuggy.addLast(2);
        BoundedIntQueueBuggy.addLast(3);
        BoundedIntQueueBuggy.addLast(4);
        BoundedIntQueueBuggy.addLast(5);
        BoundedIntQueueBuggy.addLast(6);

        assertEquals(BoundedIntQueueBuggy.removeFirst(),2);
    }

    @Test
    void removeFirst() {
        BoundedIntQueueBuggy BoundedIntQueueBuggy=new BoundedIntQueueBuggy(5);

        BoundedIntQueueBuggy.addLast(6);


        assertEquals(BoundedIntQueueBuggy.removeFirst(),6);



    }
}