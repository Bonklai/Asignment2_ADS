import java.util.Iterator;

public class MyLinkedList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;
    public MyLinkedList(){
    }
    public  void add(T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public T get(int index){
        MyNode<T> current = head;
        for(int i =0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }


    public void printList(){
        for(int i=0;i<size;i++){
            System.out.print(get(i));
            System.out.print(' ');
        }
    }


    @Override
    public Iterator<T> iterator(){
        return  new MyIterator();
    }
    private class MyIterator implements Iterator<T> {
        MyNode<T> cursor = head;
        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        @Override
        public T next() {
            T nextItem = cursor.data;
            cursor =  cursor.next;
            return nextItem;
        }
    }

}
