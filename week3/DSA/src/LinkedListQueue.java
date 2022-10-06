//Node named LinkedListQueue
public class LinkedListQueue {
    int value;
    LinkedListQueue next;

    public LinkedListQueue(int value){
        this.value = value;
        this.next = null;
    }

}

class Queue{
    //front, back using nodes
    LinkedListQueue front;
    LinkedListQueue back;

    public Queue(){
        this.front = null;
        this.back = null;
    }

    //enQueue means pushing
    void enQueue(int value){
        //create a new node
        LinkedListQueue placeholder = new LinkedListQueue(value);

        //if its empty, the new node is the front and the back
        if (this.back == null) {
            this.back = placeholder;
            this.front = placeholder;
        }
        //Adding the new node at the end of the queue and changing the back
        this.back.next = placeholder;
        this.back = placeholder;

    }

    //deQueue is pop
    public void deQueue(){
        int value;

        //If the queue is empty, return null
        if (this.front == null){
            return;
        }
        //Else, we store the front and move the front one node
        LinkedListQueue placeholder = this.front;
        this.front = this.front.next;
        //If front is null, then we know that back is also null
        if(this.front == null){
            this.back = null;
        }

    }

    public static void main(String[] args) {
        Queue myQ = new Queue();
        myQ.enQueue(1);
        myQ.enQueue(2);
        myQ.enQueue(3);

        System.out.println(myQ.front.value);
        System.out.println(myQ.back.value);

        myQ.deQueue();
        myQ.deQueue();
        myQ.deQueue();

        System.out.println(myQ.front.value);
        System.out.println(myQ.back.value);
    }

}