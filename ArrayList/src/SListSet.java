import java.util.ArrayList;
import java.util.Iterator;

public final class SListSet<E> extends SAbstractSet<E> {
    private SList<E> list=new SLinkedList<>();


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)) list.add(0,e);

    }

    @Override
    public void remove(E e) {

        Iterator<E> listIt= list.iterator();
        while (listIt.hasNext()){

            E e1=listIt.next();
            if(e1.equals(e)){
                 listIt.remove();
                  return;
            }
        }

    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }


    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
