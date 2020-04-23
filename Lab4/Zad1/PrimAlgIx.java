public class PrimAlgIx {
    private Edge[] edgeTo; //tablica przechowuje najkrotsza kawedz z MST do pozostalych wierzcholkow
    private double[] distTo; // tablica przechowuje wagen ajkrotszej krawedzi
    private boolean[] marked; // tablica przechowuje wierzchołki MST
    private IndexMinPriorityQueue<Double> pq; //priorytetowa kolejka ideksowana

    public PrimAlgIx(GraphWeighted G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPriorityQueue<Double>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) //alg. dla lasu MST
                prim(G, v);
    }

    private void prim(GraphWeighted G, int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(GraphWeighted G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.decreaseKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }
    public String MSTedges(){
        StringBuilder s = new StringBuilder();
        s.append("MST edges: \n");
        for(int i=1; i<edgeTo.length;i++)
            s.append(edgeTo[i].toString()+"\n");
        return s.toString();
    }

}