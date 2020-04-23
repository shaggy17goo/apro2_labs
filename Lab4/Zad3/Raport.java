import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Raport {
    public Raport(int rap, DigraphWeighted G) throws IOException {
        BellmanFordAlg bf = new BellmanFordAlg(G, 0);
        if(rap==1){
            System.out.println(bf.getDetailedRaport());
        }
        else{
            System.out.println(bf.getSimpleRaport());
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("droga.txt"));
        Random r = new Random();
        int v=r.nextInt(G.V());
        if (bf.hasPathTo(v)) {
            writer.write("0 -> " + v+": ");
            List<DirectEdge> temp=new ArrayList<>();
            for (DirectEdge e : bf.pathTo(v)) {
                //writer.write(e + " <- ");
                temp.add(e);
            }
            writer.write("0");
            for(int i=temp.size()-1;i>=0;i--){
                writer.write(" -> "+temp.get(i).getTo());
            }
            writer.write(" suma= "+(int)bf.distTo(v));
        }
        else {
            writer.write("Scieżka 0 -> " + v+" nie istnieje");
        }
        writer.close();
    }
}
