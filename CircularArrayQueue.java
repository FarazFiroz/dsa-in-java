import java.util.NoSuchElementException;

public class CircularArrayQueue{
    private int[] arr;
    private int size;
    private int rear = -1;
    private int front = -1;

    public CircularArrayQueue(int size){
        this.size = size;
        arr = new int[size];
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return (rear+1)%size == front;
    }

    public void add(int value){
        if(isFull()){
            System.out.println("Overflow");
            return;
        }
        if(front == -1) front = 0;
        rear = (rear+1)%size;
        arr[rear] = value;
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(front == rear) front = rear = -1;
        else front = (front+1)%size;
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[front];
    }

    public static void main(String[] args){
        CircularArrayQueue q = new CircularArrayQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.add(6);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        q.remove();
        q.peek();
    }
}