import java.io.File;
import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Graph {
    private int unions;
    private int V; //liczba wierzcholkow
    private int E; //liczba krawedzi
    private Bag<Integer>[] adj; //lista sasiedztwa
    private boolean[] marked;
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad wierzcholka!");
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " wierzcholkow, " + E + " krawedzi " +
                "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void importGraph(String path) throws FileNotFoundException {
        String[] data;
        String line;
        int checkE=0;
        int start, end;
        try {
            File txtFile = new File(path);
            Scanner scan = new Scanner(txtFile);
            V = scan.nextInt();
            E = scan.nextInt();
            scan.nextLine();
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            while (scan.hasNextLine()){
                line=scan.nextLine();
                if(line.equals(""))
                    break;
                data = line.split(" ");
                if(data.length!=2) throw new IllegalArgumentException("Błędny format pliku");
                start = Integer.parseInt(data[0]);
                end = Integer.parseInt(data[1]);
                addEdge(start, end);
                checkE++;
            }
            if(E!=checkE) throw new IllegalArgumentException("Niezgodność liczby krawędzi");
            scan.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public boolean checkPath(int firstVertex,int secondVertex){
        marked = new boolean[V];
        validateVertex(firstVertex);
        validateVertex(secondVertex);
        dfs(secondVertex);
        return marked[firstVertex];
    }
    private void dfs (int v) {
        marked[v] = true;
        for (int w : adj(v)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }
    public int disjointedUnions(){
        marked = new boolean[V];
        this.unions=0;
        this.marked=new boolean[this.V];
        for(int v=0;v<this.V;v++){
            if(!marked[v]){
                dfs(v);
                unions++;
            }
        }
        return unions;
    }
}