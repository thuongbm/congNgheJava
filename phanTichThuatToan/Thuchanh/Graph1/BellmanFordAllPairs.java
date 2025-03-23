import java.util.*;

class Edge {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class BellmanFordAllPairs {
    static final int INF = 1000000000; // Giá trị vô cực để biểu thị khoảng cách không thể đạt được

    public static int[][] bellmanFordAllPairs(int V, List<Edge> edges) {
        int[][] dist = new int[V][V];

        // Chạy Bellman-Ford từ từng đỉnh
        for (int src = 0; src < V; src++) {
            Arrays.fill(dist[src], INF);
            dist[src][src] = 0; // Khoảng cách từ src đến chính nó là 0

            // Lặp V - 1 lần
            for (int i = 0; i < V - 1; i++) {
                for (Edge e : edges) {
                    if (dist[src][e.u] != INF && dist[src][e.u] + e.w < dist[src][e.v]) {
                        dist[src][e.v] = dist[src][e.u] + e.w;
                    }
                }
            }

            // Kiểm tra chu trình âm
            for (Edge e : edges) {
                if (dist[src][e.u] != INF && dist[src][e.u] + e.w < dist[src][e.v]) {
                    System.out.println("Đồ thị có chu trình âm!");
                    return null;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 4; // Số đỉnh
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(2, 3, -2));
        edges.add(new Edge(3, 1, 2));

        int[][] shortestPaths = bellmanFordAllPairs(V, edges);

        if (shortestPaths != null) {
            System.out.println("Ma trận khoảng cách ngắn nhất:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    System.out.print((shortestPaths[i][j] == INF ? "INF" : shortestPaths[i][j]) + "\t");
                }
                System.out.println();
            }
        }
    }
}
