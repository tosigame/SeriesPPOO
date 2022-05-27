import java.util.Iterator;

public interface SSet<E> extends Iterable<E>{

    int size();
    boolean isEmpty();
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    Iterator<E> iterator();

}
