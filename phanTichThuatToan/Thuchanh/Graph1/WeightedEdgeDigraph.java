import java.util.Stack;

public class WeightedEdgeDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;                // number of vertices in this digraph
    private int E;                // number of edges in this digraph
    private Bag<DirectedEdge>[] adj; // adjacency list for each vertex
    private int[] indegree;       // indegree[v] = indegree of vertex v
    
    public WeightedEdgeDigraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }
    
    public void addVertex() {
        int newV = V + 1;
        Bag<DirectedEdge>[] newAdj = (Bag<DirectedEdge>[]) new Bag[newV];
        int[] newIndegree = new int[newV];

        for (int v = 0; v < V; v++) {
            newAdj[v] = adj[v];
            newIndegree[v] = indegree[v];
        }

        newAdj[V] = new Bag<DirectedEdge>();
        adj = newAdj;
        indegree = newIndegree;
        V = newV;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> list = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                list.add(e);
            }
        }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        WeightedEdgeDigraph G = new WeightedEdgeDigraph(5);
        System.out.println("Before adding vertex:");
        System.out.println(G);

        G.addVertex();
        G.addVertex();
        System.out.println("After adding vertices:");
        System.out.println(G);
    }
}
