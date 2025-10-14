
import java.util.NoSuchElementException;



public class ArrayQueue{
    private int[] array;
    private int rear = -1;
    private int size;

    public ArrayQueue(int size) {
        array = new int[size];
        this.size = size;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public boolean isFull(){
        return rear == size-1;
    }
    
    public void add(int value){
        if(isFull()){
            System.out.println("Overflow");
            return;
        }

        array[++rear] = value;
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("Nothing to remove");
            return;
        }

        for(int i = 0; i<rear; i++){
            array[i] = array[i+1];
        }
        rear--;
    }

    public int peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }

        return array[0];
    }

    public static void main(String[] args){
        ArrayQueue q = new ArrayQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        q.remove();
        q.peek();
    }
}