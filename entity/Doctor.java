package doctor.clinic.entity;

public class Doctor extends Human{
    private int id;
    private int numberOfPatients = 0;
    private int minutesWorked = 0;
    private int moneyMade = 0;

    public Doctor(int age, String firstName, String lastName, int id) {
        super(age, firstName, lastName);
        this.id = id;
    }

    public Doctor() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public int getMinutesWorked() {
        return minutesWorked;
    }

    public void setMinutesWorked(int minutesWorked) {
        this.minutesWorked = minutesWorked;
    }

    public int getMoneyMade() {
        return moneyMade;
    }

    public void setMoneyMade(int moneyMade) {
        this.moneyMade = moneyMade;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", numberOfPatients=" + numberOfPatients +
                ", minutesWorked=" + minutesWorked +
                ", moneyMade=" + moneyMade +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
