public class LinkedSort {

    class Node {
        int element;
        Node next;
        public Node(int e) {
            this.element = e;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedSort() {
        head = null;
        tail = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public boolean isempty() {
        return size == 0;
    }

    public void addlast(int e) {
        Node newest = new Node(e);
        if(isempty())
            head = newest;
        else
            tail.next = newest;
        tail = newest;
        size = size + 1;
    }

    public void display() {
        Node p = head;
        while(p!=null) {
            System.out.print(p.element+" --> ");
            p = p.next;
        }
        System.out.println();
    }

    public int search(int key) {
        Node p = head;
        int index = 0;
        while(p!=null) {
            if(p.element==key)
                return index;
            p = p.next;
            index = index + 1;
        }
        return -1;
    }

    public void addFirst(int e) {
        Node newest = new Node(e);
        if(isempty()) {
            head = newest;
            tail = newest;
        }
        else {
            newest.next = head;
            head = newest;
        }
        size = size + 1;
    }

    public void addAny(int e, int position) {
        Node newest = new Node(e);
        Node p = head;
        int i = 1;
        while(i<position-1) {
            p = p.next;
            i = i + 1;
        }
        newest.next = p.next;
        p.next = newest;
        size = size + 1;
    }

    public int removeFirst() {
        if(isempty()) {
            System.out.println("List is Empty");
            return -1;
        }
        int e = head.element;
        head = head.next;
        size = size - 1;
        if(isempty())
            tail = null;
        return e;
    }

    public int removeLast() {
        if(isempty()) {
            System.out.println("List is Empty");
            return -1;
        }
        Node p = head;
        int i = 1;
        while(i < size-1) {
            p = p.next;
            i = i + 1;
        }
        tail = p;
        p = p.next;
        int e = p.element;
        tail.next = null;
        size = size - 1;
        return e;
    }

    public int removeAny(int position) {
        Node p = head;
        int i = 1;
        while(i<position-1) {
            p = p.next;
            i = i + 1;
        }
        int e = p.next.element;
        p.next = p.next.next;
        size = size - 1;
        return e;
    }

    public void insertsorted(int e) {
        Node newest = new Node(e);
        if(isempty())
            head = newest;
        else {
            Node p = head;
            Node q = head;
            while(p!=null && p.element < e) {
                q = p;
                p = p.next;
            }
            if(p==head) {
                newest.next = head;
                head = newest;
            }
            else {
                newest.next = q.next;
                q.next = newest;
            }
        }
        size = size + 1;
    }

}
