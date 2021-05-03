public class LinkedList{
	class Node{
		int element;
		Node next;
		Node(int e,Node n){
			element = e;
			next = n;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void insertlast(int e){
		Node newest = new Node(e,null);
		if(isEmpty())
			head = newest;
		else {
			tail.next = newest;
		}
		tail = newest;
		size++;
	}
	public void insertfirst(int e){
		Node newest = new Node(e,null);
		if(isEmpty()){
			head = newest;
			tail = newest;
		}
		else{
			newest.next = head;
			head = newest;
		}
		size=size+1;
	}
	public void insertany(int e,int position){
		if(position<0 || position>size){
			System.out.println("Invalid poistion");
		}
		if(position==0){
			insertfirst(e);
		}
		else{
			Node newest = new Node(e,null);
			Node p = head;
			int i =0;
			while(i<position-1){
				p=p.next;
				i++;
			}
			newest.next = p.next;
			p.next = newest;
			size=size+1;
		}
	}
	public void insertsorted(int e) {
        Node newest = new Node(e, null);
        if(isEmpty())
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
	public int deletefirst(){
		if(isEmpty()){
			System.out.println("List is empty");
			return -1;
		}
		int e = head.element;
		head = head.next;
		size = size-1;
		if(isEmpty())
			tail = null;
		return e;
	}
	public int deletelast(){
		if(isEmpty()){
			System.out.println("List is empty");
			return -1;
		}
		Node p = head;
		int i =1;
		while(i<size-1){
			p=p.next;
			i++;
		}
		tail = p ;
		p = p.next;
		int e = p.element;
		tail.next = null;
		size--;
		return e;
	}
	public int deleteany(int position){
		if(position<0 || position>size-1){
			System.out.println("Invalid position");
			return -1;
		}
		if (position==0){
			int e = deletefirst();
			return e;
		}
		else{
			Node p = head;
			int i =0;
			while (i<position-1){
				p=p.next;
				i++;
			}
			int e = p.next.element;
			p.next = p.next.next;
			size--;
			return e;
		}
	}
	public int search(int key){
		Node p = head;
		int index = 0;
		while(p!= null){
			if(p.element == key)
				return index;
			p=p.next;
			index++;
		}
		return -1;
	}
	public void display(){
		Node p = head;
		//System.out.println("Linked list is: ");
		while(p!=null){
			System.out.print(p.element+"  ");
			p=p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertlast(7);
		l.insertlast(10);
		l.insertlast(15);
		l.display();
		System.out.println("Element found at "+(l.search(10)+1));
		System.out.println("Size is "+l.length());
		l.insertfirst(12);
		l.insertany(25,3);
		l.display();
		System.out.println("Size is "+l.length());
		int element = l.deletefirst();
		System.out.println("Deleted element is "+element);
		l.display();
		int ele = l.deletelast();
		System.out.println("Deleted element is "+ele);
		l.display();
		l.insertlast(50);
		l.insertlast(60);
		int e = l.deleteany(2);
		System.out.println("Deleted element is "+e);
		l.display();
	}
}