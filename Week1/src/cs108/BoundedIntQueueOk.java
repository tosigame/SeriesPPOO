package cs108;

public final class BoundedIntQueueOk implements BoundedIntQueue{

    private final int[] contents;
    private int size;
    private int headPos;
    private int lastElement;

    public BoundedIntQueueOk(int capacity){
        if(capacity<0){
            throw new IllegalStateException();
        }else{
            contents=new int[capacity];
            size=0;
            headPos=0;
            lastElement=headPos;

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
        return size==capacity();
    }


    @Override
    public void addLast(int newElement) {

        if(isFull()){
            throw new IllegalStateException("Queue full");
        }else{
            if(size<=contents.length-headPos-1){
                contents[size+headPos]=newElement;
                size++;

            }else{
                contents[size+headPos-contents.length]=newElement;
                size++;
            }
        }
    }




/*
    @Override
    public void addLast(int newElement) {
        if (isFull())
            throw new IllegalStateException("full queue");
        headPos = (headPos + 1) % contents.length;
        contents[headPos] = newElement;
        size += 1;

        for (int i = 0; i < contents.length; i++) {
            System.out.print(contents[i]+" ");
        }
        System.out.println();
        System.out.println();

        assert 1 <= size && size <= capacity();
    }


 */



    @Override
    public int removeFirst() {
        int temp;
        if(size<=0){
            throw new IllegalStateException("Empty queue");
        }else{
            temp=contents[headPos];
            for (int i = headPos; i < contents.length-1; i++) {
                contents[i]=contents[i+1];

            }
            contents[contents.length-1]=0;
            if(headPos!=0) {
                contents[contents.length - 1] = contents[0];

                for (int i = 0; i < headPos - 1; i++) {
                    contents[i] = contents[i + 1];
                }
                contents[headPos - 1]=0;
            }
            size--;
        }



        return temp;
    }


    /*
    @Override
    public int removeFirst() {
        if (isEmpty())
            throw new IllegalStateException("empty queue");
        size -= 1;
        int tailPos = Math.floorMod(headPos - size, contents.length);
        assert 0 <= size && size < capacity();


        for (int i = 0; i < contents.length; i++) {
            System.out.print(contents[i]+" ");
        }
        System.out.println();
        return contents[tailPos];
    }

     */
}

