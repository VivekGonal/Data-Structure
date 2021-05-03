public class CircularLinkedList{
	class Node{
		int element;
		Node next;
		public Node(int e,Node n){
			element = e;
			next = n ;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	public CircularLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public int length(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void insertlast(int e){
		Node newest = new Node(e,null);
		if(isEmpty()){
			newest.next = newest;
			head = newest;
		}
		else{
			newest.next = tail.next;
			tail = newest;
		}
		tail = newest;
		size = size+1;
	}
	public void insertfirst(int e){
		Node newest = new Node(e,null);
		if(isEmpty()){
			newest.next = newest;
			head = newest;
			tail = newest;
		}
		else{
			tail.next = newest;
			newest.next = head;
			head = newest;
		}
		size++;
	}
	public void insertany(int e,int position){
		if(position<=0 || position >= size){
			System.out.println("Invalid position");
			return;
		}
		Node newest = new Node(e,null);
		Node p = head;
		int i = 1;
		while(i<position-1){
			p=p.next;
			i++;
		}
		newest.next = p.next;
		p.next = newest;
		size++;
	}
	public int deletefirst(){
		if(isEmpty()){
			System.out.println("Circular Linked List is empty ");
			return -1;
		}
		int e = head.element;
		tail.next = head.next;
		head = head.next;
		size--;
		if(isEmpty()){
			head = null;
			tail = null;
		}
		return e;
	}
	public int deletelast(){
		if(isEmpty()){
			System.out.println("Circular Linked List is empty");
			return -1;		
		}
		Node p = head;
		int i = 1;
		while(i<length()-1){
			p = p.next;
			i++;
		}
		tail = p;
		p = p.next;
		tail.next = head;
		int e = p.element;
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
		size--;
		return e;
	}
	public void diplay(){
		Node p = head;
		int i = 0;
		while(i<length()){
			System.out.println(p.element+" ");
			p = p.next;
			i++;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		CircularLinkedList l =new CircularLinkedList();
		l.insertlast(5);
		l.insertlast(7);
		l.insertlast(10);
		l.deleteany(1);
		l.insertfirst(1);
		System.out.println("Size: "+l.length());
		l.diplay();
	}
}