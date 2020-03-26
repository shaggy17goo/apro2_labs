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
