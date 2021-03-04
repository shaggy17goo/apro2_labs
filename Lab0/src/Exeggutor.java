public class Exeggutor {
    public String name;
    public Exeggutor(String name){
        this.name=name;
    }
    public void setStatus(FaultStatus status, int index){
        Operator.faultsList.get(index).status=status;
    }
}
