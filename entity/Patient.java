package doctor.clinic.entity;

public class Patient extends Human{
    private Reason reason;

    public Patient(int age, String firstName, String lastName, Reason reason) {
        super(age, firstName, lastName);
        this.reason = reason;
    }

    public Patient() {
        super();
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
