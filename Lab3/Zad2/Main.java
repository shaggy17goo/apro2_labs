import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static Graph graph = new Graph();
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Podaj ścieżkę do pliku zawierającego graf: ");
        importGraph();
        System.out.println("Ilość składowych: "+graph.disjointedUnions());
        checkPath();
    }

    public static void checkPath(){
        while (true) {
            System.out.println();
            try {
                System.out.println("Sprawdź czy istnieje ścieżka między dwoma wierzchołkami");
                System.out.print("Pierwszy wierzchołek: ");
                int first=Integer.parseInt(scanner.nextLine());
                System.out.print("Drugi wierzchołek: ");
                int second=Integer.parseInt(scanner.nextLine());
                if(graph.checkPath(first,second))
                    System.out.println("Droga istnieje");
                else
                    System.out.println("Droga nie istnieje");
            }catch (IllegalArgumentException e){
                System.out.println("Niepoprawne wartości wierzchołków");
                checkPath();
            }
        }
    }

    public static void importGraph() {
        try {
            String path = scanner.nextLine();
            graph.importGraph(path);
        }
        catch (FileNotFoundException e) {
            System.out.print("Nieznaleziono pliku, podaj poprawną ścieżkę: ");
            importGraph();
        }
    }
}
