import java.util.*;

class Graph // represents the graph and contains methods to add edges and perform BFS
{
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v) // Graph constructor,initializes number of vertices (V) and creates adjacency
                        // list adj to store edges
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) // addEdge method adds an edge between two vertices by adding the second vertex
                               // to the adjacency list of the first vertex.
    {
        adj[v].add(w);
    }

    void BFS(int s) { // BFS method initializes visited array and calls BFSUtil method to perform BFS
                      // traversal.
        boolean visited[] = new boolean[V];
        BFSUtil(s, visited);
    }

    void BFSUtil(int s, boolean visited[]) { // BFSUtil method implements BFS using queue, It starts with given starting
                                             // vertex, marks it as visited, and enqueues it
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) { // It then enters a loop where it dequeues vertex from queue, processes it
                                    // (prints it in this case), and enqueues all its unvisited neighbors.
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the graph: ");
        int n = in.nextInt();
        System.out.print("Enter the size of input: ");
        int size = in.nextInt();
        Graph g = new Graph(n); // Graph object g is created, and dges are added using the addEdge method.
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
        g.BFS(start);
    }
}
