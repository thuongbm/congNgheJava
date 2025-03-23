import java.util.*;

public class DijkstraAllPairs {
    private double[][] distTo;       // distTo[v][w] = shortest distance from v to w
    private DirectedEdge[][] edgeTo; // edgeTo[v][w] = last edge on shortest v->w path

    public DijkstraAllPairs(EdgeWeightedDigraph G) {
        int V = G.V();
        distTo = new double[V][V];
        edgeTo = new DirectedEdge[V][V];

        for (int v = 0; v < V; v++) {
            dijkstra(G, v);
        }
    }

    private void dijkstra(EdgeWeightedDigraph G, int s) {
        int V = G.V();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.dist));
        Arrays.fill(distTo[s], Double.POSITIVE_INFINITY);
        distTo[s][s] = 0.0;
        pq.add(new Node(s, 0.0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.vertex;
            if (node.dist > distTo[s][v]) continue;

            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (distTo[s][w] > distTo[s][v] + e.weight()) {
                    distTo[s][w] = distTo[s][v] + e.weight();
                    edgeTo[s][w] = e;
                    pq.add(new Node(w, distTo[s][w]));
                }
            }
        }
    }

    public double dist(int v, int w) {
        return distTo[v][w];
    }

    public boolean hasPath(int v, int w) {
        return distTo[v][w] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> path(int v, int w) {
        if (!hasPath(v, w)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v][w]; e != null; e = edgeTo[v][e.from()]) {
            path.push(e);
        }
        return path;
    }

    private static class Node {
        int vertex;
        double dist;

        Node(int vertex, double dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }
}
