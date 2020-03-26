# Sprawozdanie Lab1 Michał Wawrzyńczak

W zadaniu 4.3 Metody działeją w czasie logarytmicznym ponieważ struktura oparta jest na kopcu, a na wykładzie było powiedziane że:


| Struktura danych |  Wstaw | Usuń  |
|---|---|---|---|---|
|  Tablica uporządkowana | N  | 1  |
| Tablica nieuporządkowana  | 1  |  N |
|  Kopiec |logN   | logN  | 


## Zad 4.1

### ==> Klasa FindMistakes

```java
import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Stack;

class FindMistakes {
/**
 * return true when file doesn't contain mistakes
 * return false when file contains mistakes
 */
    public boolean withoutMistakes(String path) throws IOException {
        Stack<String> stack = new Stack<>();
        final Properties props = new Properties();
        props.load(new FileReader("test1.txt"));        // ścieżka do pliku z properties
        final int count = Integer.parseInt(props.getProperty("count"));
        try {
            File xmlFile = new File(path);
            Scanner scan = new Scanner(xmlFile);
            String propertyName;
            String data;        // skan kolejnej lini
            String subData;     // podział data na kolejne znaczniki
            while (scan.hasNextLine()) {
                data = scan.nextLine();
                while (data.contains("<")) {
                    subData = data.substring(data.indexOf('<') + 1, data.indexOf('>'));     //+1 aby pominąć '<'
                    data = data.substring(data.indexOf('>') + 1);                           //+1 aby pominąć '>'
                    for (int i = 1; i <= count; i++) {
                        propertyName = "e" + i;
                        if (subData.charAt(0) != '/') {     //<xyz> znaczniki otwierające
                            if (subData.equals(props.getProperty(propertyName))) {
                                stack.push(subData);
                            }
                        }
                        if (subData.charAt(0) == '/') {     //</xyz> znaczniki zamykające
                            if (subData.substring(1).equals(props.getProperty(propertyName))) {   //sprawdzenie czy pasuje do któregoś z properties
                                if(stack.isEmpty()){return false;}
                                if (subData.substring(1).equals(stack.peek())) {                  //sprawdzenie czy pasuje do tego co chcemy zdjąć
                                    stack.pop();
                                }
                            }
                        }
                    }
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (stack.isEmpty()) {
            System.out.println("OK");
            return true;
        } else {
            System.out.println("NOK");
            return false;
        }
    }
}
```

### ==> Klasa FindMistakesTest
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.io.IOException;

public class FindMistakesTest {
    FindMistakes findMis=new FindMistakes();
    @Test
    public void test() throws IOException {
        assertTrue(findMis.withoutMistakes("test1.xml"));
        assertTrue(findMis.withoutMistakes("test2.xml"));
        assertFalse(findMis.withoutMistakes("test1fail.xml"));
        assertFalse(findMis.withoutMistakes("test2fail.xml"));
        assertFalse(findMis.withoutMistakes("test3fail.xml"));
        assertFalse(findMis.withoutMistakes("test4fail.xml"));
    }
}
```

## Zad 4.2
### ==> Klasa List
```java

public class List {
    Node head;
    int size = 0;


    public void addPatient(Patient patient) {
        Node current = head;
        Node temp1;
        //jesli lista pusta
        if (size == 0) {
            head = new Node(patient);
            size++;
        }
        //jesli priorytet nowego pacjenta wyzszy niz najwyzszy do tej pory
        else if(patient.compareTo(head.getPatient())<0){
            temp1=head;
            head=(new Node(patient));
            head.setNext(temp1);
            size++;
        }
        //jesli wiecej niz jeden pacjet w kolejce, sprawdzam do ostatniego
        else if (current.getNext() != null) {
            while (current.getNext() != null &&  patient.compareTo(current.getNext().getPatient())>=0) {
                current = current.getNext();
            }
            temp1 = current.getNext();
            current.setNext(new Node(patient));
            current.getNext().setNext(temp1);
            size++;
        }
        //jesli pacjent ma wyladowac na ostatnim miejscu
        else if((current.getNext() == null)) {
            current.setNext(new Node(patient));
            size++;
        }
    }

    public Patient takePatient(){
        Node nodeRet=head;
        head=head.getNext();
        size--;
        return nodeRet.getPatient();
    }

    @Override
    public String toString() {
        String ret="";
        if(size==0){
            ret= "Brak Pacjentów";
        }
        else {
            Node current = head;
            System.out.println("Liczba pacjentów: " + size);
            for (int i = 0; i < size; i++) {
                ret+=current.getPatient().toString()+"\n";
                current = current.getNext();
            }
        }
        return ret;
    }
}
```

### ==> Klasa Node
```java
public class Node {
    private Patient patient;
    private Node next;


    public Node(Patient patient) {
        this.patient = patient;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Node{" +
                "patient=" + patient.getPriority() +
                ", next=" + next.patient.getPriority() +
                '}';
    }
}
```

### ==> Klasa Patient
```java
import java.util.Objects;

public class Patient implements Comparable<Patient>{
    private int priority;
    private String description;
    private String name;
    public Patient(int priority, String name, String description){
        this.priority=priority;
        this.description=description;
        this.name=name;
    }

    /**
     *zwraca true jesli priorytet i imie pacjeta równe
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return priority == patient.priority &&
                (name.equals(patient.name));
    }

    @Override
    public String toString() {
        return "Patient{" +
                "priority=" + priority +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, description, name);
    }


    @Override
    public int compareTo(Patient patient) {
        if(this.priority>patient.priority)
            return 1;
        if(this.priority<patient.priority)
            return  -1;
        else
            return 0;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
```

### ==> Klasa Patient
```java
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
```