public class HeapSort{
	public void heapsort(int a[],int n){
		Heap h = new Heap();
		for(int i =0;i<n;i++)
			h.insert(a[i]);
		int k =n-1;
		for(int i = 0;i<n;i++){
			a[k] = h.deleteMax();
			k = k-1;
		}
	}
	public void display(int a[],int n){
		for(int i=0;i<n;i++)
			System.out.println(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		HeapSort s = new HeapSort();
        int a[] = {63,250,835,947,651,28};
        System.out.println("Original Array");
        s.display(a,6);
        s.heapsort(a, 6);
        System.out.println("Sorted Array");
        s.display(a, 6);
	}
}