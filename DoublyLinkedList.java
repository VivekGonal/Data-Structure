public class DoublyLinkedList{
	class Node{
		int element;
		Node prev;
		Node next;
		public Node(int e,Node n,Node p){
			element = e;
			next = n;
			prev = p;
		}
	}
	private int size;
	private Node head;
	private Node tail;
	public DoublyLinkedList(){
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
		Node newest = new Node(e,null,null);
		if(isEmpty()){
			head = newest;
			tail = newest;
		}
		else{
			tail.next = newest;
			newest.prev = tail;
			tail = newest;
		}
		size++;
	}
	public void insertfirst(int e){
		Node newest = new Node(e,null,null);
		if(isEmpty()){
			head = newest;
			tail = newest;
		}
		else{
			newest.next = head;
			head.prev = newest;
			head = newest;
		}
		size++;
	}
	public void insertany(int e,int position){
		if(position<=0 || position >= size){
			System.out.println("Invalid position");
				return;
		}
		Node newest = new Node(e,null,null);
		Node p = head;
		int i = 1;
		while(i < position-1){
			p=p.next;
			i++;
		}
		newest.next = p.next;
		p.next.prev = newest;
		p.next = newest;
		newest.prev = p;
		size++;
	}
	public int deletefirst(){
		if(isEmpty()){
			System.out.println("List is empty");
			return -1;
		}
		int e = head.element;
		head = head.next;
		size--;
		if(isEmpty())
			tail = null;
		else
			head.prev = null;
		return e;
	}
	public int deletelast(){
		if (isEmpty()) {
			System.out.println("List is empty");
			return -1;
		}
		int e = tail.element;
		tail = tail.prev;
		tail.next = null;
		size--;
		return e;
	}
	public int deleteany(int position){
		if(position <=0 || position >= size-1){
			System.out.println("Invalid position");
			return -1;
		}
		Node p = head;
		int i = 1;
		while(i < position-1){
			p = p.next;
			i++;
		}
		int e = p.next.element;
		p.next = p.next.next;
		p.next.prev = p;
		size--;
		return e;
	}
	public void display(){
		Node p = head;
		while(p!= null){
			System.out.println(p.element+" ");
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		 l.insertlast(7);
        l.insertlast(4);
        l.insertlast(12);
        l.insertlast(8);
        l.insertlast(3);
        l.display();
        System.out.println("Size: " + l.length());
        int element = l.deleteany(3);
        System.out.println("Removed Element: " + element);
        l.display();
        System.out.println("Size: " + l.length());
	}
}