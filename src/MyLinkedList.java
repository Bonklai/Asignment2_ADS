import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
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

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    public void removeFirst(){
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        size--;
    }
    public void removeLast(){
        if (head == tail){
            head = tail = null;
        }
        else{
            MyNode<T> current = head;
            while (current.next != tail){
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }


    public T get(int index){
        MyNode<T> current = head;
        for(int i =0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }


    public void printList(){
        for(int i=0;i<size;i++){
            System.out.print(get(i));
            System.out.print(' ');
        }
    }


    
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



    private  class MyNode<G> {
        G data;
        MyNode<G> next;
        
        MyNode(G data){
            this.data = data;
            next = null;
        }
    }


}
