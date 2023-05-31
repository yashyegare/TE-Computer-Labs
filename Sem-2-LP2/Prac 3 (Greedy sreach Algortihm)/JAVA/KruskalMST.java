import java.util.*;

public class KruskalMST {

    // Class representing an edge in the graph
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Compare edges based on their weights
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Method to find the minimum spanning tree using Kruskal's algo
    public void kruskal(int[][] graph, int numVertices) {

        List<Edge> edges = new ArrayList<>();
        // Extract edges from the graph and store them in a list
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (graph[i][j] != 0) {
                    Edge edge = new Edge();
                    edge.src = i;
                    edge.dest = j;
                    edge.weight = graph[i][j];
                    edges.add(edge);
                }
            }
        }

        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        // Create an array to track the parent of each vertex in the MST
        int[] parent = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new ArrayList<>();

        // Process each edge in the sorted order
        for (Edge edge : edges) {
            int srcParent = find(parent, edge.src);
            int destParent = find(parent, edge.dest);
            // If adding the edge to the MST does not form a cycle, add it to the MST
            if (srcParent != destParent) {
                mst.add(edge);
                parent[srcParent] = destParent;
            }
        }
        int sum = 0;
        // Print the edges of the MST and calculate the total weight
        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
            sum += edge.weight;
        }
        System.out.println("Minimum weight of MST: " + sum);
    }

    // Method to find the parent of a vertex using the union-find algorithm with
    // path compression
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the  size of the graph: ");
        int n = in.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter the weight " + i + "-> " + j + " of the graph: ");
                graph[i][j] = in.nextInt();
            }
        }
        KruskalMST kruskal = new KruskalMST();
        kruskal.kruskal(graph, n);
    }
}
