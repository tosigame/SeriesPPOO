package cs108;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BoundedIntQueueTest {


    @Test
    void capacity() {
        assertEquals(new BoundedIntQueueOk(5).capacity(),5);

    }

    @Test
    void size() {
        BoundedIntQueue bounded = new BoundedIntQueueOk(2);
        bounded.addLast(2);
        bounded.addLast(7);

        assertEquals(bounded.size(),2);

    }

    @Test
    void isEmpty() {
        BoundedIntQueue bounded = new BoundedIntQueueOk(3);
        assertTrue(bounded.isEmpty());

    }

    @Test
    void isFull() {
        BoundedIntQueueOk BoundedIntQueueOk=new BoundedIntQueueOk(2);

        BoundedIntQueueOk.addLast(2);
        BoundedIntQueueOk.addLast(2);
        assertTrue(BoundedIntQueueOk.isFull());
    }

    @Test
    public void constructingAQueueWithNegativeCapacityFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIntQueueOk(-1);
        });
    }

    @Test
    public void capacityIsEqualToWhatWasAsked() {
        for (int c = 0; c <= 100; ++c)
            assertEquals(c,  new BoundedIntQueueOk(c).capacity());
    }

    @Test
    public void initialSizeIsZero() {
        assertEquals(0,  new BoundedIntQueueOk(10).size());
    }

    @Test
    public void addingToQueueWithZeroCapacityFails() {
        BoundedIntQueue q = new BoundedIntQueueOk(0);
        assertThrows(IllegalStateException.class, () -> {
            q.addLast(0);
        });
    }

    @Test
    public void addingToFullQueueFails() {
        BoundedIntQueue q = new BoundedIntQueueOk(2);
        q.addLast(1);
        q.addLast(2);
        assertThrows(IllegalStateException.class, () -> {
            q.addLast(3);
        });
    }

    @Test
    public void removingFromEmptyQueueFails() {
        BoundedIntQueue q = new BoundedIntQueueOk(10);
        assertThrows(IllegalStateException.class, () -> {
            q.removeFirst();
        });
    }

    @Test
    public void sizeReturnsCorrectValue() {
        int capacity = 100;
        BoundedIntQueue q = new BoundedIntQueueOk(capacity);
        for (int i = 0; i < capacity; ++i) {
            assertEquals(i, q.size());
            q.addLast(i);
        }
    }

    @Test
    public void isEmptyIsInitiallyTrue() {
        for (int capacity = 0; capacity < 100; ++capacity) {
            BoundedIntQueue q = new BoundedIntQueueOk(capacity);
            assertTrue(q.isEmpty());
        }
    }

    @Test
    public void isFullIsInitiallyFalse() {
        for (int capacity = 1; capacity < 100; ++capacity) {
            BoundedIntQueue q = new BoundedIntQueueOk(capacity);
            assertFalse(q.isFull());
        }
    }

    @Test
    public void hasFirstInFirstOutBehavior() {
        Random rng = new Random();
        BoundedIntQueue q = new BoundedIntQueueOk(20);
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
        BoundedIntQueueOk BoundedIntQueueOk=new BoundedIntQueueOk(5);
        BoundedIntQueueOk.addLast(2);
        BoundedIntQueueOk.addLast(3);
        BoundedIntQueueOk.addLast(4);
        BoundedIntQueueOk.addLast(5);
        BoundedIntQueueOk.addLast(6);

        assertEquals(BoundedIntQueueOk.removeFirst(),3);
    }

    @Test
    void removeFirst() {
        BoundedIntQueueOk BoundedIntQueueOk=new BoundedIntQueueOk(5);

        BoundedIntQueueOk.addLast(6);


        assertEquals(BoundedIntQueueOk.removeFirst(),0);



    }
}