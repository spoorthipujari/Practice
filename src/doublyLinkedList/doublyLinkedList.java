package doublyLinkedList;

/**
 * Created by quikr on 28/03/18.
 */
public class doublyLinkedList<T> {

    Node head;

    public boolean isEmpty(){
        return head == null;
    }

    public int length(){
        int count =0;
        Node temp = head;
        while(temp!=null){
            ++count;
            temp = temp.next;
        }
        return count;
    }

    public void displayForward(){
        Node temp = head;
        System.out.print("Print forward : ");
        while(temp!=null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        System.out.print("Print backward : ");
        while(temp!=null){
            System.out.print(temp.data + "\t");
            temp = temp.prev;
        }
        System.out.println();
    }

    public void insertFirst(T data){
        Node newNode = new Node<T>(data);
        if(head!=null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T data){
        Node newNode = new Node<T>(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    public Node deleteFirst(){
        Node deleted;
        if(head == null)
        {
            return null;
        }
        deleted = head;
        head = head.next;
        if(head!=null){
            head.prev = null;
        }
        return deleted;
    }

    public Node deleteLast(){
        Node temp = head;
        if(head.next == null){
            head = null;
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;
        }
        return temp;
    }

    public Node delete(T key){
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                if(temp == head){
                    head = temp.next;
                    temp.next.prev = null;
                }
                else {
                    temp.prev.next = temp.next;
                    if(temp.next!=null)
                    temp.next.prev = temp.prev;
                }
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean insertAfter(T positionKey, T data){
        if(head == null)
            return false;
        Node temp = head;
        while(temp!=null){
            if(temp.data == positionKey){
                Node newNode = new Node<T>(data);
                newNode.prev = temp;
                if (temp.next!=null)
                    temp.next.prev = newNode;
                newNode.next = temp.next;
                temp.next = newNode;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args){
        doublyLinkedList<Integer> ddl = new doublyLinkedList<Integer>();
        ddl.insertFirst(10);
        ddl.insertFirst(32);
        ddl.insertFirst(26);
        ddl.insertFirst(1);
        ddl.insertFirst(56);

        System.out.println("length " +  ddl.length());
        ddl.displayForward();
        ddl.displayBackward();

        ddl.deleteLast();
        ddl.displayForward();

        ddl.deleteFirst();
        ddl.displayForward();

        ddl.insertLast(29);
        ddl.displayForward();

        ddl.insertAfter(26,44);
        ddl.displayForward();

        ddl.delete(1);
        ddl.displayForward();
    }
}
