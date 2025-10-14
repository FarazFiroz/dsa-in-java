import java.util.NoSuchElementException;

public class LinkedListQueue{
    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public boolean isEmpty(){
        return head == null && tail == null;
    }

    public void add(int value){
        Node node = new Node(value);
        if(isEmpty()) head = tail = node;
        else{
            tail.next = node;
            tail = node;
        }
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }

        head = head.next;
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }

        return head.value;
    }

    public static void main(String[] args){
        LinkedListQueue q = new LinkedListQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}