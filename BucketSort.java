public class BucketSort {
    private LinkedSort buckets[];

    public BucketSort() {
        buckets = new LinkedSort[10];
        for(int i=0;i<10;i++) {
            buckets[i] = new LinkedSort();
        }
    }

    public void bucketsort(int A[], int n) {
        int maxelement = max(A,n);
        for(int i=0;i<n;i++) {
            int j = (int)(n * A[i] / (maxelement + 1));
            buckets[j].addlast(A[i]);
        }
        for(int i=0;i<10;i++) {
            int x = buckets[i].length();
            int temp[] = new int[x];
            for(int j=0;j<x;j++)
                temp[j] = buckets[i].removeFirst();
            insertionsort(temp,x);
            for(int j=0;j<x;j++)
                buckets[i].addlast(temp[j]);
        }
        int k = 0;
        for(int i=0;i<10;i++) {
            int m = buckets[i].length();
            for (int j = 0; j < m; j++) {
                A[k] = buckets[i].removeFirst();
                k = k + 1;
            }
        }
    }

    public int max(int A[], int n) {
        int temp = 0;
        for(int i=0;i<n;i++)
            if (A[i]>temp)
                temp = A[i];
        return temp;
    }

    public void insertionsort(int A[], int n) {
        for(int i=1;i<n;i++) {
            int temp = A[i];
            int position = i;
            while(position>0 && A[position-1] > temp) {
                A[position] = A[position-1];
                position = position - 1;
            }
            A[position] = temp;
        }
    }

    public void display(int A[], int n) {
        for(int i=0;i<n;i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        BucketSort s = new BucketSort();
        int A[] = {54, 78, 64, 92, 34, 86, 28};
        System.out.print("Original Array: ");
        s.display(A, 7);
        s.bucketsort(A, 7);
        System.out.print("Sorted Array: ");
        s.display(A, 7);
    }
}
