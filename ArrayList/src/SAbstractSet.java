import java.util.StringJoiner;

public abstract class SAbstractSet<E> implements SSet<E> {
    @Override
    public boolean isEmpty(){return size()==0;}

    @Override
    public String toString(){
        StringJoiner j=new StringJoiner(", ","{","}");
        for (E e:this){
            j.add(e.toString());
        }
        return j.toString();
    }

}
