public class Queue<T> {
    private MyLinkedList<T> queue;
    public Queue() {
        queue = new MyLinkedList<>();
    }
    public boolean empty() {
        return queue.size() == 0;
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    public T enqueue(T item) {
        queue.addLast(item);
        return item;
    }

    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T temp = queue.getFirst();
        queue.removeFirst();
        return temp;
    }
}
