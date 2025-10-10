// Program to check whether a linked list is palindrome or not

public class LinkedList2 {
    public class Node{
        String value;
        Node next;

        Node(String value){
            this.value = value;
            this.next = null;
        }
    }
    Node head;

    public void addFirst(String value){
        Node node = new Node(value);

        if(head == null){
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void addLast(String value){
        if(head == null){
            addFirst(value);
            return;
        }
        Node curr = new Node(value);
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = curr;
    }

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void removeAll(){
        head = null;
    }

    public Node reverse(Node node){
        // Rverse the second half
        Node prev = null;
        Node curr = node;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }

        return prev;
    }
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // Get middle of the list
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now slow is our middle point
        // Divide the list into two parts first half from head to middle and th esecond half from middle+1 to end
        // Using this we will check whether the first part value is equal to second part one
        Node firstHalf = head;
        Node secondHalf = reverse(slow.next); // slow contains the mid point and we are reversing from slow+1

        while(secondHalf != null){
            if(!firstHalf.value.equals(secondHalf.value)){
                reverse(slow.next); // reverse the list again to restore previous list
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        reverse(slow.next); // reverse the list again to restore previous list  
        return true; // return true if first half = second half
    }

    public static void main(String[] args){
        LinkedList2 list = new LinkedList2();
        list.addFirst("Firoz");
        list.addFirst("Faraz");
        list.addFirst("am");
        list.addFirst("I");
        list.printList();
        list.addLast("Just");
        list.addLast("Kidding");
        list.printList();
        System.out.println(list.isPalindrome());
        list.removeAll();
        list.addFirst("Faraz");
        list.addFirst("am");
        list.addFirst("Faraz");
        list.printList();
        System.out.println(list.isPalindrome());
        list.printList();
    }
}