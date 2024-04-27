import javax.swing.plaf.multi.MultiMenuItemUI;
import java.util.Iterator;

public class MyArrayList<bro> implements MyList<bro> {
    private Object[] arr;
    private int size;
    private int capacity = 5;
    public MyArrayList(){ arr = new Object[capacity];}
    public bro get(int index){
        return (bro) arr[index];
    }

    @Override
    public bro getFirst() {
        return get(0);
    }

    @Override
    public bro getLast() {
        return get(size-1);
    }

    @Override
    public void remove(int index) {

    }

    public void add(bro item){
        if(size == capacity){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    @Override
    public void set(int index, bro item) {

    }

    @Override
    public void add(int index, bro item) {

    }

    @Override
    public void addFirst(bro item) {

    }

    public void removeFirst(){
        for(int i=0;i<size-1;i++){
            arr[i] = arr[i+1]; // move right
        }
        size--;
    }
    public void removeLast(){size--;}

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

    private void increaseBuffer(){
        capacity += 1;
        Object[] arr2 = new Object[capacity];
        if (size >= 0) System.arraycopy(arr, 0, arr2, 0, size);
        arr = arr2;
    }
    
    public int getSize(){return size;}
    public void printArr(){

        for(int i=0; i<getSize();i++){
            System.out.print(arr[i]+" ");
        }
    }
    private class MyIterator implements Iterator<bro> {
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != getSize();
        }

        @Override
        public bro next() {
            bro nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }


    @Override
    public Iterator<bro> iterator() {
        return new MyIterator();
    }
}
