public class Main {

    public static void main(String[] args) {
        //Pierwsze testy
        User user1=new User("Mciek");
        User user2=new User("Andrzej");
        Operator op=new Operator("Stefan");
        Exeggutor exe=new Exeggutor("Marcin");
        user1.reportFault("Marszałkowska 1","Mam probloem z netem");
        op.setStatusToRECEIVED(0);
        op.setExeggutor("Marcin", 0);
        op.setPriority(1,0);
        op.setOperator(op.name,0);
        //System.out.println(Operator.faultsList.get(0));
        exe.setStatus(FaultStatus.SOLVED,0);
        //System.out.println(Operator.faultsList.get(0));
        //System.out.println("");
        user1.reportFault("Marszałkowska 1","Mam probloem z netem znowu");
        user2.reportFault("Ulicowa 4","Kot mi przegryzł kabel");
        user2.reportFault("Ulicowa 4","Pies ukradł mi router");
        for(int i=0;i<Operator.faultsList.size();i++){
            System.out.println(Operator.faultsList.get(i));
        }
    }
}