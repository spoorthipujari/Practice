package stack;

/**
 * Created by quikr on 08/05/18.
 */
public class Stack<T> {

    Node<T> top;

    public void push(T data){
        Node<T> node = new Node<T>(data);
        node.next = top;
        top = node;
    }

    public T pop(){
        if(top == null)
            return null;
        Node<T> temp = top;
        top = top.next;
        return temp.data;
    }

    public static void main(String[] args){
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(21);
        integerStack.push(43);
        integerStack.push(435);
        System.out.println(integerStack.pop());
        integerStack.push(755);
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
    }
}
