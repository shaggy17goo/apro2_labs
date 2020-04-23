import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPriorityQueue<Key extends Comparable<Key>> implements Iterable<Integer> {
    private int maxN; // pojemnosc kolejki
    private int n; // liczba elementow w kolejce
    private int[] pq; // sterta do przechowywaniaindeksow
    private int[] qp; // odwrotnosc pq - qp[pq[i]] =pq[qp[i]] = i
    private Key[] keys; // tablica przechowuje klucze

    public IndexMinPriorityQueue(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }

    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) throw new
                IllegalArgumentException("Blad: indeks znajduje sie w kolejce!");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        moveUp(n);
    }

    public int delMin() {
        if (n == 0) throw new NoSuchElementException("Blad: Kolejka jest pusta");
        int min = pq[1];
        swap(1, n--);
        moveDown(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }

    //metoda pozwala ustawic nowa-mniejsza wartosc klucza
//dla danego indeksu
    public void decreaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new
                NoSuchElementException("Blad: indeksu nie ma w kolejce!");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Blad: klucz ma taka sama wartosc jak wartosc zapisana w kolejce!");
        if (keys[i].compareTo(key) < 0)
            throw new IllegalArgumentException("Blad: klucz jest wiekszy niz wartosc zapisana w kolejce!");
        keys[i] = key;
        moveUp(qp[i]);
    }

    public void increaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new
                NoSuchElementException("Blad: indeksu nie ma w kolejce!");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Blad: klucz ma taka sama wartosc jak wartosc zapisana w kolejce!");
        if (keys[i].compareTo(key) > 0)
            throw new IllegalArgumentException("Blad: klucz jest mniejszy niz wartosc zapisana w kolejce!");
        keys[i] = key;
        moveDown(qp[i]);
    }

    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("Blad: ujemny indeks: " + i);
        if (i >= maxN) throw new
                IllegalArgumentException("Blad: wartosc spoza zakresu: " + i);
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void swap(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void moveUp(int k) {
        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void moveDown(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() {
        return new
                PQIterator();
    }

    private class PQIterator implements Iterator<Integer> {
        private IndexMinPriorityQueue<Key> copy;

        public PQIterator() {
            copy = new IndexMinPriorityQueue<Key>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}