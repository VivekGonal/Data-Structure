public class Graph{
	public int vertices;
	public int adjMat[][];
	public Graph(int n){
		vertices = n;
		adjMat = new int[n][n];
	}
	public void insertEdge(int u,int v,int x){
		adjMat[u][v] = x;
	}
	public void removeEdge(int u,int v){
		adjMat[u][v] = 0;
	}
	public boolean existEdge(int u,int v){
		return adjMat[u][v]!=0;
	}
	public int vertexCount(){
		return vertices;
	}
	public int edgeCount(){
		int count =0;
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++)
				if(adjMat[i][j] !=0)
					count = count +1;		
		}
		return count;
	}
	public void edges(){
		System.out.println("Edges: ");
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++)
				if(adjMat[i][j] != 0)
					System.out.println(i+"--"+j);
		}
	}
	public int outdegree(int v){
		int count = 0;
		for(int j=0;j<vertices;j++)
			if(adjMat[v][j]!=0)
				count = count + 1;
		return count;
	}
	public int indegree(int v){
		int count = 0;
		for(int i =0;i<vertices;i++)
			if(adjMat[i][v]!=0)
				count = count + 1;
		return count;
	}
	public void display() {
        for(int i=0;i<vertices;i++) {
            for(int j=0;j<vertices;j++)
                System.out.print(adjMat[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        System.out.println("Graphs Adjacency Matrix");
        g.display();
        System.out.println("Vertices: "+g.vertexCount());
        System.out.println("Edges Count: "+g.edgeCount());
        g.insertEdge(0,1,26);
        g.insertEdge(0,2,16);
        g.insertEdge(1,2,12);
        g.insertEdge(2,3,8);
        System.out.println("Graphs Adjacency Matrix");
        g.display();
        System.out.println("Edges Count: "+g.edgeCount());
        g.edges();
        System.out.println("Edge between 1--3: "+g.existEdge(1,3));
        System.out.println("Edge between 1--2: "+g.existEdge(1,2));
        System.out.println("Edge between 2--1: "+g.existEdge(2,1));
        System.out.println("Degree of Vertex-2: "+ (g.indegree(2) + g.outdegree(2)));
        System.out.println("InDegree of Vertex-2: "+ g.indegree(2));
        System.out.println("OutDegree of Vertex-2: "+ g.outdegree(2));
        System.out.println("Graphs Adjacency Matrix");
        g.display();
        g.removeEdge(1,2);
        System.out.println("Graphs Adjacency Matrix");
        g.display();
        System.out.println("Edge between 1--2: "+g.existEdge(1,2));
    }
}
