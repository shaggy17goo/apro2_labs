import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    List list=new List();

    @org.junit.jupiter.api.Test
    void addPatient() {
        System.out.println("-----------------------------------------------------------------");
        list.addPatient(new Patient(3, "Jacek", "Ból kolana"));
        assertTrue("Jacek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(4, "Wacek", "Słaby ból kolana"));
        assertTrue("Jacek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(3, "Kuba", "Ból kolana"));
        assertTrue("Jacek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(2, "Maciek", "Mocny ból kolana"));
        assertTrue("Maciek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(3, "Kuba", "Ból kolana"));
        list.addPatient(new Patient(1, "Marek", "Bardzo mocny ból kolana"));
        assertTrue("Marek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(1, "Gacek", "Bardzo mocny ból kolana"));
        assertTrue("Marek".equals(list.head.getPatient().getName()));
        list.addPatient(new Patient(4, "Michał", "Słaby ból kolaana"));
        list.addPatient(new Patient(2, "Adam", "Mocny ból kolana"));
        System.out.println(list);
        System.out.println("-----------------------------------------------------------------");
    }

    @org.junit.jupiter.api.Test
    void takePatient() {
        assertTrue("Brak Pacjentów".equals(list.toString()));
        System.out.println("-----------------------------------------------------------------");
        list.addPatient(new Patient(3, "Jacek", "Ból kolana"));
        list.addPatient(new Patient(1, "Gacek", "Bardzo mocny ból kolana"));
        list.addPatient(new Patient(4, "Wacek", "Słaby ból kolana"));
        list.addPatient(new Patient(2, "Maciek", "Mocny ból kolana"));;
        list.addPatient(new Patient(3, "Kuba", "Ból kolana"));
        list.addPatient(new Patient(1, "Marek", "Bardzo mocny ból kolana"));
        list.addPatient(new Patient(4, "Michał", "Słaby ból kolaana"));
        list.addPatient(new Patient(2, "Adam", "Mocny ból kolana"));
        System.out.println(list);
        System.out.println("-----------------------------------------------------------------");
        assertTrue("Gacek".equals(list.takePatient().getName()));
        assertFalse("Maciek".equals(list.takePatient().getName()));
        System.out.println(list);

    }
}