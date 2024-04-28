import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.multi.MultiMenuItemUI;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<bro> implements MyList<bro> {
    private Object[] arr;
    private int size;
    private int capacity = 5;
    public MyArrayList(){ arr = new Object[capacity];} //help
    public bro get(int index){
        return (bro) arr[index];
    }

    @Override
    public bro getFirst() {
        return get(0); //just getting first element by index 0
    }

    @Override
    public bro getLast() {
        return get(size-1); //just get last using get method
    }



    public void add(bro item){
        if(size == capacity){ //we will firstly increase buffer of array before adding a new element
            increaseBuffer();//this method copies itself and return new array increasing capacity
        }
        arr[size++] = item; //adding an element to the end;
    }

    @Override
    public void set(int index, bro item) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index out");
        }
        else{
            arr[index] = item;
        }
    }

    @Override
    public void add(int index, bro item) {
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index out"); //if index is out  we will throw an exception
        }
        if(size == capacity){
            increaseBuffer(); // if size is equal to capacity we will increase buffer calling this method
        }
        for(int i=size;i>index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public void addFirst(bro item) {
        add(0,item); //simple
    }
    public void addLast(bro item){
        add(item); //its simple
    }
    @Override
    public void remove(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Индексін асып кеттіғой е"); //it throws an exxception if our index is less than 0 or more or equal size
        }else{
            for(int i =index;i<size-1;i++){
                arr[i]= arr[i+1];
            }
            arr[--size] = null;
        }
    }


    public void removeFirst(){
        remove(0); //simple
    }
    public void removeLast(){
        remove(size-1); //again simple
    }

    @Override
    public void sort() {
        for(int i=0;i<size-1;i++){
            for(int j=0;j<size-1-i;j++){
                if (compare(arr[j],arr[j+1])>0){
                    Object temp = arr[j]; //swaping
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private int compare(Object a,Object b){
        Comparable comparable = (Comparable) a;
        return  comparable.compareTo(b);
    }

    @Override
    public int indexOf(Object object) {
        for(int i=0;i<size;i++){
            if(arr[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i=size-1;i>=0;i--){
            if(arr[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size];
        for (int i=0;i<size;i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void clear() {
        size = 0; //clear arr after setting the size to 0
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseBuffer(){
        capacity += 1;
        Object[] arr2 = new Object[capacity];
        if (size >= 0) System.arraycopy(arr, 0, arr2, 0, size);
        arr = arr2;
    }

    public void printArr(){

        for(int i=0; i<size;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private class MyIterator implements Iterator<bro> {
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != size;
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
