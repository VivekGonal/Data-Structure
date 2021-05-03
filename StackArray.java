public class StackArray{
	private int data[];
	private int top;
	public StackArray(int n){
		data = new int[n];
		top = 0;
	}
	public int length(){
		return top;
	}
	public boolean isEmpty(){
		return top==0;
	}
	public boolean isFull(){
		return top==data.length;
	}
	public void push(int e){
		if(isFull()){
			System.out.println("Stack Overflow");
			return;
		}
		else{
			data[top] = e;
			top++;
		}
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack Underflow");
			return -1;
		}
		int e = data[top-1];
		top--;
		return e;
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack Underflow");
			return -1;
		}
		return data[top-1];
	}
	public void display(){
		for(int i=0;i<top;i++)
			System.out.println(data[i]+" ");
		System.out.println();
	}
	public static void main(String args[]) {
        StackArray s = new StackArray(10);
        s.push(5);
        s.push(3);
        s.display();
        System.out.println("Size: " + s.length());
        System.out.println("Element Popped: "+s.pop());
        System.out.println("IsEmpty: " + s.isEmpty());
        System.out.println("Element Popped: "+s.pop());
        System.out.println("IsEmpty: " + s.isEmpty());
        s.push(7);
        s.push(9);
        s.display();
        System.out.println("Element Top: "+s.peek());
        s.display();
    }
}