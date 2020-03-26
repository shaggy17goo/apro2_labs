
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
