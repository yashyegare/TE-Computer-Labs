import java.util.*;

class Graph // contains methods to add edges and perform DFS
{
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v]; // Graph constructor, it initializes the number of vertices (V) and creates an
                                 // adjacency list adj to store the edges.
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) // add edges between the two vertices
    {
        adj[v].add(w);
    }

    void DFS(int v) {
        boolean already[] = new boolean[V];
        DFSUtil(v, already);
    }

    void DFSUtil(int vertex, boolean visit[]) // DFS method initializes visited array and calls DFSUtil method to
                                              // perform DFS traversal.
    {

        visit[vertex] = true;
        System.out.print(vertex + " ");
        int a = 0;
        for (int i = 0; i < adj[vertex].size(); i++) {
            a = adj[vertex].get(i);
            if (!visit[a]) {
                DFSUtil(a, visit);
            }
        }
    }

}

class Main // main method where user input is taken to create the graph and perform DFS
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the graph: ");
        int n = in.nextInt();
        System.out.print("Enter the size of input: ");
        int size = in.nextInt();
        Graph g = new Graph(n); // The Graph object g is created, and the edges are added using the addEdge
                                // method
        for (int i = 0; i < size; i++) {
            System.out.print("Enter edges  " + (i + 1) + " of graph: ");
            int j = in.nextInt();
            int k = in.nextInt();
            if (j < n && k < n) {
                g.addEdge(j, k);
            } else {
                System.out.println("Invalid Input");
            }
        }
        System.out.println("Enter the starting vertex: ");
        int start = in.nextInt();
        System.out.println("BFS of Graph");
        g.DFS(start);
    }
}
