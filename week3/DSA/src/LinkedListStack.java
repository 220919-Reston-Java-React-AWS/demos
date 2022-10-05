public class LinkedListStack {
    //head Node property
    private Node head;

    //Nested class for Node -> value, next
    private class Node{
        int value;
        Node next;
    }

    public LinkedListStack (){
        this.head = null;
    }

    //push, add value to the beginner of the list
    public void push(int value) {
        Node lastHead = head;

        head = new Node();
        head.value = value;
        head.next = lastHead;

    }

    //pop, remove value from the beginning of the list

    public int pop() {
        int value = head.value;
        head = head.next;

        return value;
    }


    public static void main(String[] args) {
        //Used for Testing

        LinkedListStack llStack = new LinkedListStack();
        llStack.push(10);
        llStack.push(20);
        llStack.push(33);

        System.out.println(llStack.head.value);
        System.out.println(llStack.pop());

        System.out.println(llStack.head.value);

    }
}
