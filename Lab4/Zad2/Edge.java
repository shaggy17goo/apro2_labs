public class Edge {

    private final int v;
    private final int w;
    private final double weight;
    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");
        if (w < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");
        if (Double.isNaN(weight)) throw new
                IllegalArgumentException("Blad! to nie jest liczba.");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() { return weight; }

    public int either() { return v; }

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new IllegalArgumentException("Blad! vertex nie jest elementem krawedzi.");
    }

    public int compareTo(Edge e) {
        return Double.compare(this.weight, e.weight);
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
