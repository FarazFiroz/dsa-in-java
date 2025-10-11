
import java.util.EmptyStackException;

// We are building stack data structure with linked list

public class StackLL{
    // Make linked list
    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    
    public boolean isEmpty(){
        return head == null;
    }

    public void push(int value){
        if(isEmpty()) head = new Node(value);
        else{
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    public void pop(){
        if(isEmpty()) return;
        head = head.next;
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return head.value;
    }

    public static void main(String[] args){
        StackLL stack = new StackLL();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}