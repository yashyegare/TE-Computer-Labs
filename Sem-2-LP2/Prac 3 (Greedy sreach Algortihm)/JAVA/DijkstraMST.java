import java.util.*;

public class DijkstraMST {

    private int numVertices;
    private int[] dist;
    private boolean[] visited;
    private int[][] graph;

    public DijkstraMST(int[][] graph, int numVertices) {
        this.numVertices = numVertices;
        this.graph = graph;
        this.dist = new int[numVertices];
        this.visited = new boolean[numVertices];
    }

    public void dijkstra(int startVertex) {
        // Initialize distances and visited array
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        // Distance of start vertex from itself is 0
        dist[startVertex] = 0;
        // Iterate over all vertices
        for (int i = 0; i < numVertices - 1; i++) {
            // Find the vertex with the minimum distance
            int u = minDistance(dist, visited);
            // Mark the vertex as visited
            visited[u] = true;

            // Update the distances of neighboring vertices
            for (int v = 0; v < numVertices; v++) {
                // Update the distance if:
                // - The vertex is not visited
                // - There is an edge between u and v
                // - The total distance through u is shorter than the current distance to v
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the minimum distances from the start vertex
        printMST(startVertex);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        // Find the vertex with the minimum distance that is not visited yet
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && dist[i] <= minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printMST(int startVertex) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
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
        DijkstraMST dijkstra = new DijkstraMST(graph, n);
        System.out.print("Enter the starting vertex of the graph: ");
        int vertex = in.nextInt();
        dijkstra.dijkstra(vertex);
    }
}
