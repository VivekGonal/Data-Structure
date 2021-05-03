public class Heap{
	private int data[];
	private int maxsize;
	private int csize;
	public Heap(){
		maxsize = 10;//limit
		data = new int[maxsize];//heap array
		csize = 0;//size of heap
		for (int i=0;i<data.length;i++){
			data[i] = -1;
		}
	}
	public int length(){
		return csize;
	}
	public boolean isEmpty(){
		return csize == 0;
	}
	public void insert(int e){
		if(csize == maxsize){
			System.out.println("No space in heap");
			return;
		}
		csize = csize + 1;
		int hi =csize;
		while(hi > 1 && e > data[hi/2]){
			data[hi] = data[hi/2];
			hi = hi/2;
		}
		data[hi] = e;
	}
	public int deleteMax(){
		if(isEmpty()){
			System.out.println("Heap is Empty");
			return -1;
		}
		int e = data[1];
		data[1] = data[csize];
		data[csize] = -1;
		csize--;
		int i = 1;
		int j = i * 2;
		while(j<=csize){
			if(data[j]< data[j+1])
				j = j+1;
			if(data[i]<data[j]){
				int temp = data[j];
				data[j] = data[i];
				data[i] = temp;
				i = j;
				j= i*2;
			}
			else
				break;
		}
		return e;
	}
	public int max(){
		if (isEmpty()) {
			System.out.println("Heap is empty");
			return -1;
		}
		return data[1];
	}
	public void display(){
		for(int i=0;i<data.length;i++)
			System.out.println(data[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
 		Heap h = new Heap();
        h.insert(25);
        h.insert(14);
        h.insert(2);
        h.insert(20);
        h.insert(10);
        h.insert(40);
        System.out.println("Heap Data:");
        h.display();
        int element = h.deleteMax();
        System.out.println("Removed Element: " + element);
        h.display();		
	}
}