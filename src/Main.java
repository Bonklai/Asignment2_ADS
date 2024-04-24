import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Baha");
        list.add("Isa");
        list.add("Jan");
        list.printList();
    }
}