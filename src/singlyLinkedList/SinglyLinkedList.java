package singlyLinkedList;

/**
 * Created by quikr on 26/03/18.
 */
public class SinglyLinkedList<T> {

    public Node<T> head;

    //display list
    public void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    //insert key at first location
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(head ==null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    //delete first element
    public Node deleteFirst() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    //is list Empty
    public boolean isEmptyList() {
        return head == null;
    }

    //length of list
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            ++length;
            temp = temp.next;
        }
        return length;
    }

    //find node with given key
    public Node find(T key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key)
                return temp;
        }
        return null;
    }

    //delete first node with given key
    public Node delete(T key) {
        Node current = head;
        Node prev = head;
        while (current != null) {
            if (current.data == key) {
                if (current == head){
                    head = current.next;
                } else {
                    prev.next = current.next;
                    break;
                }
            }
            prev = current;
            current = current.next;
        }
        return current;
    }

    //reverse linked list
    public Node reverse(){
        Node prev = null;
        Node current = head;
        Node next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args){
        SinglyLinkedList<Integer> ssl = new SinglyLinkedList<>();
        ssl.insertFirst(9);
        ssl.insertFirst(6);
        ssl.insertFirst(1);
        ssl.insertFirst(2);
        ssl.insertFirst(3);
        ssl.displayList();
        System.out.println("Length = " + ssl.length());

        ssl.delete(3);
        ssl.displayList();
        System.out.println("Length = " + ssl.length());

        ssl.deleteFirst();
        ssl.displayList();
        System.out.println("Length = " + ssl.length());

        ssl.insertFirst(8);
        ssl.insertFirst(10);
        ssl.displayList();
        ssl.reverse();
        ssl.displayList();
        System.out.println("Length = " + ssl.length());

    }

}
