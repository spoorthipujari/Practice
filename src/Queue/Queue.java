package Queue;

/**
 * Created by quikr on 08/05/18.
 */
public class Queue<T>{

    Node first = null, last = null;

    public void add(T data){
        Node<T> node = new Node<T>(data);
        if(last!=null)
            last.next = node;
        last = node;
        if(first == null)
            first = node;
    }

    public T remove(){
        if(first == null)
            return null;
        Node<T> temp = first;
        first = first.next;
        if(first == null)
            last = null;
        return temp.data;
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(234);
        queue.add(95);
        queue.add(755);
        queue.add(847);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
