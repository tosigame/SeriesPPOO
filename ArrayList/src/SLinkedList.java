import java.util.Iterator;
import java.util.NoSuchElementException;

public final class SLinkedList<E> extends SAbstractList<E> {

    private Node<E> head=null;
    private int size=0;

    private Node<E> getNode(int i){
        Node<E> n =head;
        for (int j = 0; j < i; j++) {
            n=n.next;
        }
        return n;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int i, E e) {
        if(checkPositionIndex(i)==0) {
            head =new Node<>(head,e);
        }else{
            Node<E> pred=getNode(i-1);
            pred.next=new Node<>(pred.next,e);
        }
        size+=1;
    }

    @Override
    public void remove(int i) {

        if(checkElementIndex(i)==0){
            head=head.next;
        } else{
            Node<E> pred=getNode(i-1);
            pred.next=pred.next.next;
        }

        size-=1;

    }

    @Override
    public E get(int i) {
        return getNode(checkElementIndex(i)).elem ;
    }

    @Override
    public E set(int i, E e) {
        Node<E> n=getNode(checkElementIndex(i));
        E oldE=n.elem;
        n.elem=e;
        return oldE;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            boolean canRemove=false;
            Node<E> next=head;
            Node<E> curr=null;
            Node<E> pred=null;

            @Override
            public boolean hasNext() {
                return next!=null;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new NoSuchElementException();
                E e=next.elem;
                pred=curr;
                curr=next;
                next=next.next;
                canRemove=true;
                return e;
            }

            @Override
            public void remove(){
                if(!canRemove) throw new IllegalStateException();
                if(pred==null){
                    head=head.next;
                }else {
                    pred.next=pred.next.next;
                }

                curr=pred;
                pred=null;
                size-=1;

                canRemove = false;
            }

        };
    }

    private final static class Node<E>{
        Node<E> next;
        E elem;
        public Node(Node<E> next,E elem){
            this.next=next;
            this.elem=elem;
        }

    }
}
