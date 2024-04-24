public class MyNode<G> {
    G data;
    MyNode<G> next;
    MyNode(G data){
        this.data = data;
        next = null;
    }
}
