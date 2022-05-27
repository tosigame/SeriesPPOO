import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public final class SHashSet<E> extends SAbstractSet<E> {
    public static final double MAX_LOAD_FACTOR = 1.0;
    public static final double MIN_LOAD_FACTOR = 0.4;
    public static final double IDEAL_LOAD_FACTOR = 0.7;
    public static final int MIN_CAPACITY = 10;
    private  SList<E>[] table=createTable(10);
    private int size=0;




    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        SList<E> list= getList(table, e);
        if(!list.contains(e)){
            list.add(0,e);
            size+=1;
            rehashIfNeeded();
        }
    }


    @Override
    public void remove(E e) {
        SList<E> list= getList(table, e);
        Iterator<E> listIt= list.iterator();
        while(listIt.hasNext()){
            E e1= listIt.next();
            if(e1.equals(e)){
                listIt.remove();
                size-=1;
                rehashIfNeeded();
                return;
            }
        }
    }

    @Override
    public boolean contains(E e) {
        return getList(table, e).contains(e);
    }


    public void myForeach(Consumer<E> consumer){
        for (int i = 0; i < table.length; i++) {
            Iterator<E> listIt=table[i].iterator();
            while(listIt.hasNext()){
                E e=listIt.next();
                consumer.accept(e);
            }
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int remaining=size;
            int listIndex=0;
            Iterator<E> listIt=table[listIndex].iterator();

            @Override
            public boolean hasNext() {
                return remaining>0;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new NoSuchElementException();
                while(!listIt.hasNext()){
                    listIndex+=1;
                    listIt=table[listIndex].iterator();

                }
                remaining-=1;
                return listIt.next();
            }


            @Override
            public void remove(){
                listIt.remove();
                size-=1;
            }
        };



    }



    private void rehashIfNeeded(){
        double loadFactor=(double) size/(double) table.length;
        if(MIN_LOAD_FACTOR <=loadFactor && loadFactor<= MAX_LOAD_FACTOR)return;

        int idealCapacity= (int) (size/ IDEAL_LOAD_FACTOR);
        if(idealCapacity<= MIN_CAPACITY) return;

        SList<E>[] newTable=createTable(idealCapacity);


        for (E e:this){
            getList(newTable,e).add(0,e);
        }
        table=newTable;


    }

    private static <E> SList<E> getList(SList<E>[] table, E e) {
        return table[Math.floorMod(e.hashCode(), table.length)];
    }

    private static <E> SList<E>[] createTable(int size){
        SList<E>[] table= new SList[size];
        for (int i = 0; i < size; i++) {
            table[i]=new SLinkedList<>();
        }
        return table;
    }
}
