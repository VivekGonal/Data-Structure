public class QueueLinked {

    class Node {
        int element;
        Node next;
        public Node(int e, Node n) {
            element = e;
            next = n;
        }
    }

    private Node front;
    private Node rear;
    private int size;
    public QueueLinked() {
        front = null;
        rear = null;
        size = 0;
    }
    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int e) {
        Node newest = new Node(e, null);
        if(isEmpty())
            front = newest;
        else
            rear.next = newest;
        rear = newest;
        size = size + 1;
    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int e = front.element;
        front = front.next;
        size = size - 1;
        if(isEmpty())
            rear = null;
        return e;
    }

    public void display() {
        Node p = front;
        while(p!=null) {
            System.out.print(p.element+" ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        QueueLinked q = new QueueLinked();
        q.enqueue(5);
        q.enqueue(3);
        q.display();
        System.out.println("Size: "+q.length());
        System.out.println("Element Removed: "+q.dequeue());
        System.out.println("IsEmpty: "+q.isEmpty());
        System.out.println("Element Removed: "+q.dequeue());
        System.out.println("IsEmpty: "+q.isEmpty());
        q.enqueue(7);
        q.enqueue(9);
        q.display();
        q.enqueue(4);
        q.display();
        System.out.println("Size: "+q.length());
        System.out.println("Element Removed: "+q.dequeue());
        q.enqueue(6);
        q.enqueue(8);
        q.display();
        System.out.println("Element Removed: "+q.dequeue());
    }
}
