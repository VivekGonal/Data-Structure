public class CountSort{
	public int max(int a[],int n){
		int temp = 0;
		for(int i=0;i<n;i++)
			if(a[i]>temp)
				temp = a[i];
		return temp;
	}
	public void countsort(int a[],int n){
		int maxsize = max(a,n);
		int carray[] = new int[maxsize+1];
		for(int i=0; i<n;i++)
			carray[a[i]] = carray[a[i]] + 1;
		int j=0;
		int i=0;
		while(i <maxsize+1){
			if(carray[i]>0){
				a[j] = i;
				j = j+1;
				carray[i] = carray[i] - 1;
			}
			else
				i = i+1;
		}
	}
	public void display(int a[],int n){
		for(int i=0;i<n;i++)
			System.out.println(a[i]+" ");
		System.out.println();
	}
	public static void main(String[] args){
		CountSort s = new CountSort();
        int a[] = {3, 5, 8, 9, 6, 2, 3, 5, 5};
        System.out.print("Original Array: ");
        s.display(a, 9);
        s.countsort(a, 9);
        System.out.print("Sorted Array: ");
        s.display(a, 9);
	}
}