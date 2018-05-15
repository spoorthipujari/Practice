package singlyLinkedList;

/**
 * Created by quikr on 26/03/18.
 */
public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}
