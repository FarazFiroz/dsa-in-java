
import java.util.ArrayList;
import java.util.EmptyStackException;

// we be building stack data structure using array list

public class StackAL{
    private ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(int value){
        list.add(value);
    }

    public void pop(){
        if(isEmpty()) return;
        list.remove(list.size()-1);
    }

    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return list.get(list.size()-1);
    }

    public static void main(String[] args){
        StackAL stack = new StackAL();
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