import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphWeighted {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public GraphWeighted(int V) {
        if (V < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    public int V() { return V; }
    public int E() { return E; }

    private void validVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad! wierzcholek nie nalezy do grafu.");
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validVertex(v);
        validVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        validVertex(v);
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
            }
        }
        return list;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
