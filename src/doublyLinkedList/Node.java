package doublyLinkedList;

/**
 * Created by quikr on 28/03/18.
 */
public class Node<T> {
    T data;
    Node prev;
    Node next;

    public Node(T data){
        this.data = data;
        prev = null;
        next = null;
    }

}
