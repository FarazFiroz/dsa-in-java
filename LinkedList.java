public class LinkedList {
    class Node {
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    int getQuickSize;

    public LinkedList() {
        getQuickSize = 0;
    }

    public void addFirst(String data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        getQuickSize++;
    }

    public void addLast(String data){
        if(head == null){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;

        getQuickSize++;
    }

    public void add(int idx, String data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        if(idx == getQuickSize){
            addLast(data);
            return;
        }
        if(idx<0 || idx>=getQuickSize){
            throw new IndexOutOfBoundsException("Invalid Index: " + idx);
        }
        Node newNode = new Node(data);
        Node prevNode = getNode(idx-1);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        getQuickSize++;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("There is nothing to delete");
            return;
        }
        head = head.next;

        getQuickSize--;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("Nothing to delete");
            return;
        }

        getQuickSize--;

        if(head.next == null){
            head = null;
            return;
        }

        Node slNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            slNode = lastNode;
            lastNode = lastNode.next;
        }

        slNode.next = null;
    }

    public void delete(int idx){
        if(idx == 0){
            deleteFirst();
            return;
        }
        if(idx == getQuickSize -1){
            deleteLast();
            return;
        }
        if(idx<0 || idx>=getQuickSize){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }
        Node prevNode = getNode(idx-1);
        prevNode.next = prevNode.next.next;
        getQuickSize--;
    }

    public Node getNode(int idx){
        if(idx < 0 || idx>=getQuickSize){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }
        Node currNode = head;
        for(int i=0; i<idx; i++){
            currNode = currNode.next;
        }
        return currNode;
    }

    public String getData(int idx){
        if(idx < 0 || idx>=getQuickSize){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }
        Node currNode = head;
        for(int i=0; i<idx; i++){
            currNode = currNode.next;
        }
        return currNode.data;
    }

    public Node getNext(int idx){
        if(idx < 0 || idx>=getQuickSize){
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        }
        Node currNode = head;
        for(int i=0; i<idx; i++){
            currNode = currNode.next;
        }
        return currNode.next;
    }

    public void printList(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public int getSize(){
        int size = 0;
        Node currNode = head;
        while(currNode != null){
            size++;
            currNode = currNode.next;
        }

        return size;
    }

    public void clear(){
        head = null;
        getQuickSize = 0;
    }

    public void reverseIterative(){
        if(head == null || head.next == null){
            return;
        }

        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.addFirst("I");
        list.addFirst("am");
        list.addFirst("Faraz");
        list.addFirst("Firoz");
        list.printList();
        list.reverseIterative();
        list.printList();
        Node node = list.reverseRecursive(list.head);
        while(node!=null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}