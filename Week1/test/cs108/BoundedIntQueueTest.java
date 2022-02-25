package cs108;

import org.junit.jupiter.api.Test;

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
        BoundedIntQueueOk BoundedIntQueueOk=new BoundedIntQueueOk(1);
        BoundedIntQueueOk.addLast(2);
        assertThrows(IllegalStateException.class,()->{
            BoundedIntQueueOk.addLast(2);
        });
    }
}