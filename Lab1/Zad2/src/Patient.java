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
            return this.priority-patient.priority;
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
