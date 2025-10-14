
import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueDS{
    public static void main(String[] args){
        // Using collections framework
        /* Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        } */


       QueueDS q = new QueueDS();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.remove();
       while(!q.isEmpty()){
        System.out.println(q.remove());
       }
    }

    // Make a queue using two stacks
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty(){
        return s1.isEmpty();
    }

    public void add(int value){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(value);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int remove(){
        if(s1.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return s1.pop();
    }

    public int peek(){
        if(s1.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return s1.peek();
    }
}