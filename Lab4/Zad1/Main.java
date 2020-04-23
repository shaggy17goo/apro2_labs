import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static PrimAlgIx primAlgIx;
    static GraphWeighted G;
    public static void main(String[] args) throws FileNotFoundException {
        importGraph("graph.txt");
        primAlgIx=new PrimAlgIx(G);
        System.out.println(G.toString());
        System.out.println(primAlgIx.MSTedges());
    }

    public static void importGraph(String path) throws FileNotFoundException {
        String[] data;
        String line;
        int either, other;
        double weight;
        try {
            File txtFile = new File(path);
            Scanner scan = new Scanner(txtFile);
            int V = Integer.parseInt(scan.nextLine());
            int E = Integer.parseInt(scan.nextLine());
            G=new GraphWeighted(V);
            while (scan.hasNextLine()){
                line=scan.nextLine();
                if(line.equals(""))
                    break;
                data = line.split(" ");
                if(data.length!=3) throw new IllegalArgumentException("Błędny format pliku");
                either = Integer.parseInt(data[0]);
                other = Integer.parseInt(data[1]);
                weight =Double.parseDouble(data[2]);
                G.addEdge(new Edge(either,other,weight));
            }
            if(E!=G.E()) throw new IllegalArgumentException("Niezgodność liczby krawędzi");
            scan.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

}
