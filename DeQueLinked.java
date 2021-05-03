public class DeQueLinked {
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

    public DeQueLinked() {
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

    public void addlast(int e) {
        Node newest = new Node(e, null);
        if(isEmpty())
            front = newest;
        else
            rear.next = newest;
        rear = newest;
        size = size + 1;
    }

    public void addFirst(int e) {
        Node newest = new Node(e, null);
        if(isEmpty()) {
            front = newest;
            rear = newest;
        }
        else {
            newest.next = front;
            front = newest;
        }
        size = size + 1;
    }

    public int removeFirst() {
        if(isEmpty()) {
            System.out.println("List is Empty");
            return -1;
        }
        int e = front.element;
        front = front.next;
        size = size - 1;
        if(isEmpty())
            rear = null;
        return e;
    }

    public int removeLast() {
        if(isEmpty()) {
            System.out.println("List is Empty");
            return -1;
        }
        Node p = front;
        int i = 1;
        while(i < size-1 ) {
            p = p.next;
            i = i + 1;
        }
        rear = p;
        p = p.next;
        int e = p.element;
        rear.next = null;
        size = size - 1;
        return e;
    }

    public int search(int key) {
        Node p = front;
        int index = 0;
        while(p!=null) {
            if(p.element==key)
                return index;
            p = p.next;
            index = index + 1;
        }
        return -1;
    }

    public int first() {
        if(isEmpty()) {
            System.out.println("DeQue is Empty");
            return -1;
        }
        return front.element;
    }

    public int last() {
        if(isEmpty()) {
            System.out.println("DeQue is Empty");
            return -1;
        }
        return rear.element;
    }

    public void display() {
        Node p = front;
        while(p!=null) {
            System.out.print(p.element + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DeQueLinked d = new DeQueLinked();
        d.addFirst(5);
        d.addFirst(3);
        d.addlast(7);
        d.addlast(12);
        d.display();
        System.out.println("Size: " + d.length());
        System.out.println("Front Element Removed: " + d.removeFirst());
        System.out.println("Rear Element Removed: " + d.removeLast());
        d.display();
        System.out.println("First Element: " + d.first());
        System.out.println("Last Element: " + d.last());
    }
}
