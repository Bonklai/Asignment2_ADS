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
            head = tail = newNode; //just from learn
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode<T> current = head; //taking first element
        for(int i=0;i<index;i++){
            current = current.next; //and moving till need elemenet
        }
        current.data = item;
    }

    @Override
    public void add(int index, T item) {
        MyNode<T> current = head; //setting first element
        MyNode<T> newNode = new MyNode<>(item);
        for(int i=0;i<index;i++){
            current = current.next; //and moving till need element
        }
        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0,item); // simplee
    }
    public void addLast(T item){
        add(size-1,item);
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
        boolean swap = true;
        while(swap){
            swap = false;

            MyNode<T> previous = null;
            for(MyNode<T> current = head; current != null && current.next!=null;current=current.next ){
                if(((Comparable<T>) current.data).compareTo(current.next.data)>0){
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swap = true;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        short index = 0;
        while(current!=null){
            if(current.data.equals(object)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -5;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = head;
        short lastIndex = -1;
        short index = 0;
        while (current!= null){
            if(current.data.equals(object)){
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;

    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> current = head;
        while(current!=null){
            if(current.data.equals(object)){
                return true;
            }
            current = current.next;

        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size]; // Create an array of the same size as the list
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data; // Add each element of the list to the array
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head=tail=null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size-1);
    }

    @Override
    public void remove(int index) {
        MyNode<T> current = head;
        for(int i=0 ; i<index-1;i++){
            current = current.next; //moving till the element [1,2,3,4]
        }
        current.next = current.next.next;
        if(current.next == null){
            tail = current;
        }
        size--;
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



    private  class MyNode<T> {
        T data;
        MyNode<T> next;
        
        MyNode(T data){
            this.data = data;
            next = null;
        }
    }


}
