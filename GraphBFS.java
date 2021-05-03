public class GraphBFS {

    public int vertices;
    public int adjMat[][];

    public GraphBFS(int n) {
        vertices = n;
        adjMat = new int[n][n];
    }

    public void insertEdge(int u, int v, int x) {
        adjMat[u][v] = x;
    }

    public void removeEdge(int u, int v) {
        adjMat[u][v] = 0;
    }

    public boolean existEdge(int u, int v) {
        return adjMat[u][v] != 0;
    }

    public int vertexCount() {
        return vertices;
    }

    public int edgeCount() {
        int count = 0;
        for(int i=0;i<vertices;i++) {
            for (int j = 0; j < vertices; j++)
                if(adjMat[i][j]!=0)
                    count = count + 1;
        }
        return count;
    }

    public void edges() {
        System.out.println("Edges:");
        for(int i=0;i<vertices;i++) {
            for (int j = 0; j < vertices; j++)
                if(adjMat[i][j]!=0)
                    System.out.println(i+"--"+j);
        }
    }

    public int outdegree(int v) {
        int count = 0;
        for(int j=0;j<vertices;j++)
            if(adjMat[v][j]!=0)
                count = count + 1;
        return count;
    }

    public int indegree(int v) {
        int count = 0;
        for(int i=0;i<vertices;i++)
            if(adjMat[i][v]!=0)
                count = count + 1;
        return count;
    }

    public void display() {
        for(int i=0;i<vertices;i++) {
            for (int j = 0; j < vertices; j++)
                System.out.print(adjMat[i][j] + "\t");
            System.out.println();
        }
    }

    public void BFS(int s) {
        int i = s;
        QueueLinked q = new QueueLinked();
        int visited[] = new int[vertices];
        System.out.print(i+" ");
        visited[i] = 1;
        q.enqueue(i);
        while(!q.isEmpty()) {
            i = q.dequeue();
            for(int j=0;j<vertices;j++) {
                if(adjMat[i][j]==1 && visited[j] ==0) {
                    System.out.print(j+" ");
                    visited[j] = 1;
                    q.enqueue(j);
                }
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS bfs = new GraphBFS(7);
        bfs.insertEdge(0, 1, 1);
        bfs.insertEdge(0, 5, 1);
        bfs.insertEdge(0, 6, 1);
        bfs.insertEdge(1, 0, 1);
        bfs.insertEdge(1, 2, 1);
        bfs.insertEdge(1, 5, 1);
        bfs.insertEdge(1, 6, 1);
        bfs.insertEdge(2, 3, 1);
        bfs.insertEdge(2, 4, 1);
        bfs.insertEdge(2, 6, 1);
        bfs.insertEdge(3, 4, 1);
        bfs.insertEdge(4, 2, 1);
        bfs.insertEdge(4, 5, 1);
        bfs.insertEdge(5, 2, 1);
        bfs.insertEdge(5, 3, 1);
        bfs.insertEdge(6, 3, 1);
        System.out.println("BFS:");
        bfs.BFS(0);
    }
}
