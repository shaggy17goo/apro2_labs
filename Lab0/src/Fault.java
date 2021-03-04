import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Fault implements Comparable<Fault> {
    public int id;
    public String adress;
    public LocalDate date;
    public String description;
    public int priority;
    public FaultStatus status;
    public String client;
    public String operator;
    public String exeggutor;

    public Fault(String adress,LocalDate date,String description,String client){
        this.id=Operator.faultsList.size()+1;
        this.adress=adress;
        this.date=date;
        this.description=description;
        this.priority=2;
        this.status= FaultStatus.DEFAULT;
        this.client=client;
        this.operator="null";
        this.exeggutor="null";
    }
    @Override
    public String toString(){
        return id + " " + adress+ " " + date + " " +description + " " +client + " " +status + " " +operator + " " +exeggutor;
    }

    @Override
    public int compareTo(Fault fault) {
        return this.status.compareTo(fault.status);
    }

    public static List<Fault> sortByPriority(){
        List<Fault> sorted=Operator.faultsList;
        Collections.sort(sorted);
        return sorted;
    }
}

