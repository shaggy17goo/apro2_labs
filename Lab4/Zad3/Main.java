import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static DigraphWeighted G;
    static Raport rap;
    public static void main(String[] args) throws IOException {
        G = new DigraphWeighted("graph.txt");
        System.out.println("Struktura grafu:");
        System.out.println(G);
        /**
         *  przy tworzeniu raportu pierwszy parameter: 1 aby wyświetlić raport rozszerzony, cokolwiek innego raport rozszerzony
         *  ścieżka z wierzchołka 0 do innego losowego zapisana w pliku droga.txt
         */
        System.out.println("Raport z działania algorytmu:");
        rap = new Raport(0,G);
    }
}
