public class DirectEdge {

    private final int from;
    private final int to;
    private final int weight;
    public DirectEdge(int from, int to, int weight) {
        if (from < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");
        if (to < 0) throw new IllegalArgumentException("Blad! liczba nie moze byc ujemna.");
        if (Double.isNaN(weight)) throw new
                IllegalArgumentException("Blad! to nie jest liczba.");
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double weight() { return weight; }

    public int getFrom() { return from; }

    public int getTo(){ return to;}

    public int compareTo(DirectEdge e) {
        return Integer.compare(this.weight, e.weight);
    }
    public String toString() {
        return String.format("%d->%d (%d),", from, to, weight);
    }
}
