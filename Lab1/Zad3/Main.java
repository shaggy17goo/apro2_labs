import java.io.FileNotFoundException;

public class Main {

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryHeap heapLex = new BinaryHeap(1, "listy.txt");
        System.out.println(heapLex.size());
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);

        BinaryHeap heapLen = new BinaryHeap(2, "listy.txt");
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);

    }
}
