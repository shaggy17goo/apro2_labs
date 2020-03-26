import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BinaryHeap {
    Word[] heap;
    private int n;
    int type;
    String path;

    public BinaryHeap(int type) {
        this(type, 1);
    }

    public BinaryHeap(int type, int size) {
        heap = new Word[size + 1];
        n = 0;
        this.type = type;
    }

    public BinaryHeap(int type, Word[] words) {
        this.type = type;
        n = words.length;
        heap = new Word[n];
        for (int i = 0; i < n; i++)
            heap[i + 1] = words[i];
        for (int k = n / 2; k >= 1; k--)
            moveDown(k);
    }


    public BinaryHeap(int type,String path) throws FileNotFoundException {
        this.n=0;
        this.type=type;
        this.heap=new Word[15];
        importTxt(path);
    }

    public void insert(Word word) {
        heap[++n] = word; //wstawienie na koniec tablicy
        moveUp(n); //przesuniecie nowego elementu do gory drzewie binarnym
        if (n == heap.length - 1)
            resize(2 * heap.length);
    }

    public Word delMin() {
        if (isEmpty()) throw new
                NoSuchElementException("Kolejka jest pusta");
        Word min = heap[1]; //zdjecie korzenia drzewa
        swap(1, n--); //przeniesienie ostatniego elementu
        moveDown(1); //przesunięcie elementu w dol drzewa
        heap[n + 1] = null; //porzadkowanie tablicy
        if ((n > 0) && (n == (heap.length - 1) / 4))
            resize(heap.length / 2);
        return min;
    }

    public Word delMax() {
        if (isEmpty()) throw new
                NoSuchElementException("Kolejka jest pusta");
        Word max = heap[1]; //zdjecie korzenia drzewa
        swap(1, n--); //przeniesienie ostatniego elementu
        moveDown(1); //przesunięcie elementu w dol drzewa
        heap[n + 1] = null; //porzadkowanie tablicy
        if ((n > 0) && (n == (heap.length - 1) / 4))
            resize(heap.length / 2);
        return max;
    }


    private void moveUp(int k) {

        while (k > 1 && greater(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }

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
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            swap(k, j);
            k = j;

        }
    }

    public Word min() {
        if (isEmpty()) throw new
                NoSuchElementException("Kolejka jest pusta");
        return heap[1];
    }

    private void swap(int i, int j) {
        Word tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void resize(int size) {
        Word[] temp = new Word[size];
        for (int i = 0; i <= n; i++)
            temp[i] = heap[i];
        heap = temp;
    }

    private boolean greater(int i, int j) {
        switch (type) {
            case 1:
                return heap[i].compareTo1(heap[j]) > 0;
            case 2:
                return heap[i].compareTo2(heap[j]) > 0;
            default:
                return false;
        }
    }


    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void importTxt(String path) throws FileNotFoundException {
        String line;
        try {
            File xmlFile = new File(path);
            Scanner scan = new Scanner(xmlFile);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] words = line.split("\\W+");
                for (int i = 0; i < words.length; i++) {
                    if(words[i].equals(""))
                        continue;
                    this.insert(new Word(words[i]));
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
