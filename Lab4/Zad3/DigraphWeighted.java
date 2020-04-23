import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DigraphWeighted {
    private final int V;
    private int E;
    private Bag<DirectEdge>[] adj;

    public DigraphWeighted(String path) throws FileNotFoundException {
        String[] data;
        String line;
        int either, other;
        int weight;
        try {
            File txtFile = new File(path);
            Scanner scan = new Scanner(txtFile);
            V = Integer.parseInt(scan.nextLine());
            E = Integer.parseInt(scan.nextLine());
            adj = (Bag<DirectEdge>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<>();
            }
            while (scan.hasNextLine()){
                line=scan.nextLine();
                if(line.equals(""))
                    break;
                data = line.split(" ");
                if(data.length!=3) throw new IllegalArgumentException("Błędny format pliku");
                either = Integer.parseInt(data[0]);
                other = Integer.parseInt(data[1]);
                weight =Integer.parseInt(data[2]);
                addEdge(new DirectEdge(either,other,weight));
            }
            if(E!=E()) throw new IllegalArgumentException("Niezgodność liczby krawędzi");
            scan.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    private void validVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad! wierzcholek nie nalezy do grafu.");
    }
    public void addEdge(DirectEdge e) {
        int v = e.getFrom();
        int w = e.getTo();
        validVertex(v);
        validVertex(w);
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectEdge> adj(int v) {
        validVertex(v);
        return adj[v];
    }

    public Iterable<DirectEdge> edges() {
        Bag<DirectEdge> list = new Bag<DirectEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectEdge e : adj(v)) {
                if (e.getTo() > v) {
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
            for (DirectEdge e : adj[v]) {
                s.append(e + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
