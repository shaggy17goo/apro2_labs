import java.time.LocalDate;

public class User {
    public User(String client){
        this.client=client;
    }
    public Fault fault;
    public String client;
    public String adress;
    public String description;
    public LocalDate date;
    public void reportFault( String adress, String description) {
        this.adress = adress;
        this.description=description;
        this.date = LocalDate.now();
        this.fault = new Fault(this.adress, this.date, this.description, this.client);
        Operator.faultsList.add(this.fault);
    }
}
