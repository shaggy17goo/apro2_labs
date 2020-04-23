import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAlg {
    ArrayList<Edge> mst = new ArrayList<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>(Edge::compareTo);
    private double weight;

    public KruskalAlg(GraphWeighted G) {
        for (Edge e : G.edges()) {
            pq.add(e);
        }
        Union u = new Union(G.V()); //sprawdzenie cykli, klasa do zaimplementowania
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (!u.connected(v, w)) {
                u.union(v, w);
                mst.add(e);
                weight += e.weight();
            }
        }
    }

    public String MSTedges(){
        StringBuilder s = new StringBuilder();
        s.append("MST edges: \n");
        for(int i=0; i<mst.size();i++)
            s.append(mst.get(i).toString()+"\n");
        s.append("Size: "+mst.size());
        return s.toString();
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
