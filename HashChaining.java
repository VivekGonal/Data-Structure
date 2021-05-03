public class HashChaining {
    private int hashtablesize;
    private LinkedList hashtable[];

    public HashChaining() {
        hashtablesize = 10;
        hashtable = new LinkedList[hashtablesize];
        for(int i=0;i<hashtablesize;i++)
            hashtable[i] = new LinkedList();
    }

    public int hashcode(int key) {
        return key % hashtablesize;
    }

    public void insert(int element) {
        int i = hashcode(element);
        hashtable[i].insertsorted(element);
    }

    public boolean search(int key) {
        int i = hashcode(key);
        return hashtable[i].search(key) != -1;
    }

    public void display() {
        for(int i=0;i<hashtablesize;i++) {
            System.out.print("[" + i + "]");
            hashtable[i].display();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        HashChaining h = new HashChaining();
        h.insert(54);
        h.insert(78);
        h.insert(64);
        h.insert(92);
        h.insert(34);
        h.insert(86);
        h.insert(28);
        h.display();
        System.out.println("Element Found: "+h.search(44));
    }
}
