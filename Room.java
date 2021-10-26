package doctor.clinic;

import doctor.clinic.entity.Doctor;
import doctor.clinic.entity.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Room extends Thread {
    private Stack<Patient> patientStack;
    private Stack<Doctor> doctorStack;
    private int workedMinutes = 0;
    private final int maxWorkMinutesDoctor = 420;
    private int maxWorkMinutesClinic;


    public Room(Stack<Patient> patientStack, Stack<Doctor> doctorStack, int maxWorkMinutesClinic) {
        this.patientStack = patientStack;
        this.doctorStack = doctorStack;
        this.maxWorkMinutesClinic = maxWorkMinutesClinic;
    }

    public void run() {
        while (!doctorStack.empty()) {
            Doctor doctor = new Doctor();
            doctor = doctorStack.pop();
            try {
                while (!patientStack.empty()
                        && maxWorkMinutesDoctor >= patientStack.peek().getReason().getTime()
                        + doctor.getMinutesWorked() && workedMinutes + patientStack.peek().getReason().getTime() < maxWorkMinutesClinic) {
                    Patient patient = patientStack.pop();
                    doctor.setMinutesWorked(doctor.getMinutesWorked() + patient.getReason().getTime());
                    doctor.setMoneyMade(doctor.getMoneyMade() + patient.getReason().getMoney());
                    doctor.setNumberOfPatients(doctor.getNumberOfPatients() + 1);
                    workedMinutes += patient.getReason().getTime();
                }
            } catch (Exception ex) {
                System.out.println("Empty stack");
                System.out.println(this.getName() + "   " + doctor);
                return;
            }
            System.out.println(this.getName() + "   " + doctor);
        }
    }
}
