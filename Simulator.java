package doctor.clinic;

import doctor.clinic.entity.Doctor;
import doctor.clinic.entity.Patient;

import java.util.List;
import java.util.Stack;

public class Simulator {
    private List<Patient> patients;
    private Stack<Patient> patientsStack = new Stack<>();
    private Stack<Doctor> doctorsStack = new Stack<>();

    public void simulate(List<Doctor> doctorList, List<Patient> patientList, int maxWorkMinutesClinic) {
        this.patients = patientList;
        orderPatientsByGroupAge();
        for (Doctor d : doctorList) {
            this.doctorsStack.push(d);
        }

        Room room1 = new Room(patientsStack, doctorsStack, maxWorkMinutesClinic);
        Room room2 = new Room(patientsStack, doctorsStack, maxWorkMinutesClinic);
        Room room3 = new Room(patientsStack, doctorsStack, maxWorkMinutesClinic);
        Room room4 = new Room(patientsStack, doctorsStack, maxWorkMinutesClinic);
        room1.start();
        room2.start();
        room3.start();
        room4.start();

        while(true) {
            if (!room1.isAlive() && !room2.isAlive() && !room3.isAlive() && !room4.isAlive()) {
                System.out.println("\nClinic closed, patients remaining :\n");
                while(!patientsStack.empty()){
                    System.out.println(patientsStack.pop());
                }
                return;
            }
        }

    }

    private void orderPatientsByGroupAge() {
        for (Patient p : this.patients) {
            if (p.getAge() > 17) patientsStack.push(p);
        }
        for (Patient p : this.patients) {
            if (p.getAge() > 6 && p.getAge() < 18) patientsStack.push(p);
        }
        for (Patient p : this.patients) {
            if (p.getAge() > 0 && p.getAge() < 7) patientsStack.push(p);
        }
        for (Patient p : this.patients) {
            if (p.getAge() == 0) patientsStack.push(p);
        }
    }


}
