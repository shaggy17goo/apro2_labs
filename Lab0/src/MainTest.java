import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

public class MainTest {
    User user1=new User("Mciek");
    User user2=new User("Andrzej");
    User user3=new User("Edward");
    Operator op=new Operator("Stefan");
    Exeggutor exe=new Exeggutor("Marcin");

    @Test
    public void testInteractions(){
        //generating some data
        user1.reportFault("Marszałkowska 1","Mam probloem z netem");
        assertEquals("Marszałkowska 1",Operator.faultsList.get(0).adress);
        user1.reportFault("Marszałkowska 1","Mam probloem z netem znowu");
        assertEquals("Mam probloem z netem znowu",Operator.faultsList.get(1).description);
        user2.reportFault("Ulicowa 4","Kot mi przegryzł kabel");
        assertEquals("Ulicowa 4",Operator.faultsList.get(2).adress);
        user2.reportFault("Ulicowa 4","Pies ukradł mi router");
        assertEquals("Andrzej",Operator.faultsList.get(3).client);
        user1.reportFault("Złota 10", "Nie działa internet");
        assertEquals("Złota 10",Operator.faultsList.get(4).adress);
        user3.reportFault("Grójecka 124", "Kot się wywalił");
        assertEquals("Kot się wywalił",Operator.faultsList.get(5).description);
        user3.reportFault("Growa 2143", "Komputer się pali");
        assertEquals("Edward",Operator.faultsList.get(6).client);

        Fault.sortByPriority();
        op.setExeggutor("Marcin",3);
        assertEquals("Marcin",Operator.faultsList.get(3).exeggutor);
        op.setOperator("Stefan",1);
        assertEquals("Stefan",Operator.faultsList.get(1).operator);
        op.setPriority(1,5);
        assertEquals(1,Operator.faultsList.get(5).priority);
        op.setStatusToRECEIVED(6);
        assertEquals(FaultStatus.RECEIVED,Operator.faultsList.get(6).status);
        exe.setStatus(FaultStatus.LIVE,5);
        assertEquals(FaultStatus.LIVE,Operator.faultsList.get(5).status);
        exe.setStatus(FaultStatus.SOLVED,5);
        assertEquals(FaultStatus.SOLVED,Operator.faultsList.get(5).status);
        exe.setStatus(FaultStatus.UNSOLVED,1);
        assertEquals(FaultStatus.UNSOLVED,Operator.faultsList.get(1).status);



    }
}