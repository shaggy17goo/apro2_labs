import java.io.FileNotFoundException;

public class Main {

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("porządek leksykalny:");
        BinaryHeap heapLex = new BinaryHeap(1, "listy.txt");
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);
        System.out.println(heapLex.delMin().string);

        System.out.println();
        System.out.println("porządek długościowy:");
        BinaryHeap heapLen = new BinaryHeap(2, "listy.txt");
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);
        System.out.println(heapLen.delMin().string);


        System.out.println();
        System.out.println("słowo z maksymalna liczba wystapien");
        System.out.println(heapLex.maxTimes());
        System.out.println();

    }
}
