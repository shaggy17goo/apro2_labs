import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BellmanFordAlg {
    private StringBuilder simpleRaport = new StringBuilder();
    private StringBuilder detailedRaport = new StringBuilder();
    private int simple, detailed;
    private double[] distTo; //dlugosc sciezki s->v
    private DirectEdge[] edgeTo; //ostatnia krawedz sciezki s->v
    private boolean[] onQueue; //obecnośc v w kolejce
    private ListQueue<Integer> queue; //wierzcholki wkolejce


    public BellmanFordAlg(DigraphWeighted G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectEdge[G.V()];
        onQueue = new boolean[G.V()];
        detailedRaport.append(detailed++ + ". Tworzenie tablice distTo, edgeTo, onQueue\n");
        detailedRaport.append(detailed++ + ". Ustawianie dystans z wierzchołka s do innych na nieskończoność iterując tablicę\n");
        simpleRaport.append(simple++ + ". Ustawianie dystans z wierzchołka s do innych na nieskończoność\n");
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        detailedRaport.append(detailed++ + ". Ustawia dystant z wierzchołka s do niego samego na 0\n");
        simpleRaport.append(simple++ + ". Ustawia dystant z wierzchołka s do niego samego na 0\n");

        //Algorytm Bellmana-Forda
        queue = new ListQueue<Integer>();
        detailedRaport.append(detailed++ + ". Tworzenie kolejki wierzcholków\n");
        queue.enqueue(s);
        detailedRaport.append(detailed++ + ". Dodanie wierzchołka s na początek kolejki\n");
        onQueue[s] = true;
        detailedRaport.append(detailed++ + ". Ustawienie flagi obecności w kolejce wierzchołka s na true\n");
        simpleRaport.append(simple++ + ". Pętla while do póki kolejka nie jest pusta\n");
        while (!queue.isEmpty()) {
            detailedRaport.append("     "+detailed++ + ". Zdjęcie z kolejki pierwszego elementu i zapisanie go w v\n");
            int v = queue.dequeue();
            detailedRaport.append("     "+detailed++ + ". Zmiana flagi obecności wierzchołka" + v +" w kolejce na false\n");
            onQueue[v] = false;
            detailedRaport.append("     "+detailed++ + ". Wejście w metodę relax dla wierzchołka " +v+ "\n");
            simpleRaport.append("     "+simple++ + ". Wejście w metodę relax dla wierzchołka " +v+ "\n");

            relax(G, v);
        }
    }

    private void relax(DigraphWeighted G, int v) {
        detailedRaport.append("          "+detailed++ + ". Rozpoczęcie pentli iterującej po krawędzich wychodzących z wierzchołka "+ v + "\n");
        simpleRaport.append("          "+simple++ + ". Rozpoczęcie pentli iterującej po krawędzich wychodzących z wierzchołka "+ v + "\n");
        for (DirectEdge e : G.adj(v)) {
            detailedRaport.append("             "+detailed++ + ". Przypisanie int w równe drugiemu końcowi krawędzi e("+e.getTo()+") \n");
            simpleRaport.append("             "+simple++ + ". Przypisanie int w równe drugiemu końcowi krawędzi e("+e.getTo()+") \n");
            int w=e.getTo();
            detailedRaport.append("             "+detailed++ + ". Jeżeli dystans z s do w większy niż z s do v do + długość e \n");
            simpleRaport.append("             "+simple++ + ". Jeżeli dystans z s do w większy niż z s do v do + długość e \n");
            if (distTo[w] > distTo[v] + e.weight()) {
                detailedRaport.append("               "+detailed++ + ". Przypisanie do dystasnu do w dystansu do v + długość e \n"+
                        "                   przypisanie do edgeTo od w krawędź e= " +e+"\n");
                simpleRaport.append("               "+simple++ + ". Przypisanie do dystasnu do w dystansu do v + długość e \n"+
                        "                   przypisanie do edgeTo od w krawędź e= " +e+"\n");
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                detailedRaport.append("               "+detailed++ + ". Jeżeli wierzchołek w = " + w+ " nie znajduje się w kolejce to go dopisujemy\n");
                simpleRaport.append("               "+simple++ + ". Jeżeli wierzchołek w = " + w+ " nie znajduje się w kolejce to go dopisujemy\n");
                if (!onQueue[w]) {
                    queue.enqueue(w);
                    onQueue[w] = true;
                }
            }
        }
    }

    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<DirectEdge> path = new Stack<DirectEdge>();
        for (DirectEdge e = edgeTo[v]; e != null; e =
                edgeTo[e.getFrom()]) {
            path.push(e);
        }
        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad! wierzcholek nie nalezy do grafu.");
    }

    public String getSimpleRaport(){
        return simpleRaport.toString();
    }

    public String getDetailedRaport(){
        return detailedRaport.toString();
    }
}