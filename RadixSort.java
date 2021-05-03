public class RadixSort {

    public void radixsort(int A[], int n) {
        int maxelement = max(A, n);
        int digits = numberofdigits(maxelement);

        for(int i=0;i<digits;i++) {
            LinkedSort bins[] = new LinkedSort[10];
            for(int x=0;x<10;x++) {
                bins[x] = new LinkedSort();
            }

            for(int j=0;j<n;j++) {
                int e = (int) ((A[j] / Math.pow(10,i)) % 10);
                bins[e].addlast(A[j]);
            }
            int k = 0;
            for(int x=0;x<10;x++)
                if(bins[x].length() > 0) {
                    int m = bins[x].length();
                    for (int y = 0; y < m; y++) {
                        A[k] = bins[x].removeFirst();
                        k = k + 1;
                    }
                }
        }
    }

    public int numberofdigits(int n) {
        int digits = 0;
        while (n != 0) {
            n = n / 10;
            digits++;
        }
        return digits;
    }

    public int max(int A[], int n) {
        int temp = 0;
        for(int i=0;i<n;i++)
            if (A[i]>temp)
                temp = A[i];
        return temp;
    }

    public void display(int A[], int n) {
        for(int i=0;i<n;i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        RadixSort s = new RadixSort();
        int A[] = {63, 250, 835, 947, 651, 28};
        System.out.print("Original Array: ");
        s.display(A, 6);
        s.radixsort(A, 6);
        System.out.print("Sorted Array: ");
        s.display(A, 6);
    }

}