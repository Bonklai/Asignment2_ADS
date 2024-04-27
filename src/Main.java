import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Baha");
        list.add("Isa");
        list.add("Jan");
        list.removeLast();
        list.printList();
    }
}