package cs108;

import org.junit.jupiter.api.Test;

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
        BoundedIntQueueBuggy boundedIntQueueBuggy=new BoundedIntQueueBuggy(2);

        boundedIntQueueBuggy.addLast(2);
        boundedIntQueueBuggy.addLast(2);
        assertTrue(boundedIntQueueBuggy.isFull());
    }

    @Test
    void addLast() {
        BoundedIntQueueBuggy boundedIntQueueBuggy=new BoundedIntQueueBuggy(5);
        boundedIntQueueBuggy.addLast(2);
        boundedIntQueueBuggy.addLast(3);

        assertEquals(boundedIntQueueBuggy.removeFirst(),3);
    }

    @Test
    void removeFirst() {
        BoundedIntQueueBuggy boundedIntQueueBuggy=new BoundedIntQueueBuggy(1);
        boundedIntQueueBuggy.addLast(2);
        assertThrows(IllegalStateException.class,()->{
            boundedIntQueueBuggy.addLast(2);
        });
    }
}