public class MyStack<T> {
    private MyArrayList<T> stack;
    public MyStack(){
        stack = new MyArrayList<>();
    }
    public boolean empty(){
        return stack.size() == 0;
    }
    public int size(){
        return stack.size();
    }
    public T peek(){
        return stack.getLast();
    }
    public void push(T item){
        stack.add(item);
    }
    public T pop(){
        if(empty()){
            throw new IllegalStateException("Stack is empty!!!!!");
        }
        T temp = stack.get(size()-1);
        stack.remove(size()-1);
        return temp;
    }




}
