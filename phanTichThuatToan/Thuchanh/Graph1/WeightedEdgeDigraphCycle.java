import java.util.*;

class DirectedEdge {
    private final int from, to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() { return from; }
    public int to() { return to; }
    public double weight() { return weight; }
}

class WeightedEdgeDigraph {
    private final List<List<DirectedEdge>> adj;
    private int V;

    public WeightedEdgeDigraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addVertex() {
        adj.add(new ArrayList<>());
        V++;
    }

    public void addEdge(DirectedEdge e) {
        adj.get(e.from()).add(e);
    }

    public int V() { return V; }
    public List<DirectedEdge> adj(int v) { return adj.get(v); }
}

class CycleChecker {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean hasCycle;

    public CycleChecker(WeightedEdgeDigraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(WeightedEdgeDigraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (hasCycle) return;
            else if (!marked[w]) {
                dfs(G, w);
            } else if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}

public class WeightedEdgeDigraphCycle {
    public static void main(String[] args) {
        WeightedEdgeDigraph G = new WeightedEdgeDigraph(3);
        G.addEdge(new DirectedEdge(0, 1, 1.0));
        G.addEdge(new DirectedEdge(1, 2, 2.0));
        G.addEdge(new DirectedEdge(2, 0, 3.0)); // Tạo chu trình
        
        CycleChecker checker = new CycleChecker(G);
        System.out.println("Has cycle: " + checker.hasCycle());
    }
}
