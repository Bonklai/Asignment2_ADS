import javax.swing.plaf.multi.MultiMenuItemUI;
import java.util.Iterator;

public class MyArrayList<bro> implements Iterable<bro> {
    private Object[] arr;
    private int size;
    private int capacity = 5;
    public MyArrayList(){ arr = new Object[capacity];}
    public bro get(int index){
        return (bro) arr[index];
    }
    public void add(bro item){
        if(size == capacity){
            increaseBuffer();
        }
        arr[size++] = item;
    }
    public void removeFirst(){
        for(int i=0;i<size-1;i++){
            arr[i] = arr[i+1]; // move right
        }
        size--;
    }
    public void removeLast(){size--;}
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
