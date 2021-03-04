import java.util.ArrayList;
import java.util.List;

public class Operator {
    public String name;
    public Operator(String name){
        this.name=name;
    }
    public static List<Fault> faultsList = new ArrayList<>();
    public void setStatusToRECEIVED(int index){
        faultsList.get(index).status=FaultStatus.RECEIVED;
    }
    public void setPriority(int priority, int index){
        faultsList.get(index).priority=priority;
    }
    public void setOperator(String name, int index){
        faultsList.get(index).operator=name;
    }
    public void setExeggutor(String name, int index){
        faultsList.get(index).exeggutor=name;
    }
}
