package cs108;

public final class BoundedIntQueueOk implements BoundedIntQueue{

    private final int[] contents;
    private int size;
    private int headPos;

    public BoundedIntQueueOk(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException();
        }else{
            contents=new int[capacity];
            size=0;
            headPos=2;

        }
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
        return (size==0);
    }

    @Override
    public boolean isFull() {
        return size==contents.length;
    }

    @Override
    public void addLast(int newElement) {

        if(isFull()){
            throw new IllegalArgumentException("Queue full");
        }else{
            if(size<=contents.length-headPos-1){
                contents[size+headPos]=newElement;
                size++;

            }else{
                contents[size+headPos-contents.length]=newElement;
                size++;
            }
        }
        for (int i = 0; i < contents.length; i++) {
            System.out.print(contents[i]+" ");
        }
        System.out.println();
    }

    @Override
    public int removeFirst() {
        return 0;
    }
}
