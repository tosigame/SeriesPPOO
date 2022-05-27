import java.util.Iterator;
import java.util.StringJoiner;

public abstract class SAbstractList<E> implements SList<E> {




    @Override
    public boolean isEmpty(){return size()==0;}


    @Override
    public boolean contains(E e) {
        for (E e1: this){
            if(e1.equals(e))return true;
        }
        return false;
    }

    @Override
    public String toString(){
        StringJoiner j=new StringJoiner(", ","[","]");

        for (E e: this){
            j.add(e.toString());
        }
        return j.toString();
    }

    protected int checkElementIndex(int i){
        if(!(0<= i && i<size()))throw new IndexOutOfBoundsException();
        return i;
    }

    protected int checkPositionIndex(int i) {
        if (!(0 <= i && i <= size())) throw new IndexOutOfBoundsException();
        return i;
    }
}
