package cs108;

public final class BoundedIntQueueBuggy implements BoundedIntQueue {
    private final int[] contents;
    private int size;
    private int headPos;

    public BoundedIntQueueBuggy(int capacity) {
        if (!(capacity >= 0))
            throw new IllegalArgumentException(
                    "illegal capacity: " + capacity + " (must be >= 0)");
        contents = new int[capacity];
        size = 0;
        headPos = 0;
    }

    @Override
    public int capacity() {
        return contents.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity();
    }

    @Override
    public void addLast(int newElement) {
        if (isFull())
            throw new IllegalStateException("full queue");
        headPos = (headPos + 1) % contents.length;
        contents[headPos] = newElement;
        size += 1;


    }

    @Override
    public int removeFirst() {
        if (isEmpty())
            throw new IllegalStateException("empty queue");
        size -= 1;
        int tailPos = (headPos - size + contents.length) % contents.length;

        return contents[tailPos];
    }
}
