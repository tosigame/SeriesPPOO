import java.util.Iterator;
import java.util.NoSuchElementException;

public final class SArrayList<E> extends SAbstractList<E> {

    private E[] array = (E[]) new Object[10];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int i, E e) {
        checkPositionIndex(i);
        if (size < array.length) {
            System.arraycopy(array, i, array, i + 1, size - 1);

        } else {
            E[] newArray = (E[]) new Object[2 * array.length];
            System.arraycopy(array, 0, newArray, 0, i);
            System.arraycopy(array, i, newArray, i + 1, size - i);
            array = newArray;

        }
        array[i] = e;
        size += 1;
    }

    @Override
    public void remove(int i) {
        checkElementIndex(i);
        System.arraycopy(array, i + 1, array, i, size - i - 1);
        size -= 1;
        array[size] = null;

    }

    @Override
    public E get(int i) {
        return array[checkElementIndex(i)];
    }

    @Override
    public E set(int i, E e) {
        E oldE = array[checkElementIndex(i)];
        array[i] = e;
        return oldE;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            int nextI = 0;
            boolean canRemove = false;


            @Override
            public boolean hasNext() {
                return nextI < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                canRemove = true;
                return array[nextI++];
            }

            public void remove() {

                if (!canRemove) throw new IllegalStateException();
                canRemove = false;
                SArrayList.this.remove(--nextI);
            }
        };

    }
}
