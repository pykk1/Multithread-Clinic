package doctor.clinic;


import doctor.clinic.entity.Doctor;
import doctor.clinic.entity.Patient;
import doctor.clinic.util.FileWrite;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GenerateDoctors generateDoctors = new GenerateDoctors();
        ManipulatePatients manipulatePatients = new ManipulatePatients();
        List<Doctor> doctorList = generateDoctors.generateListOfDoctors(8,30,65);
        List<Patient> patientList = manipulatePatients.generateListOfPatients(100);

        for(Doctor d : doctorList){
            System.out.println(d);
        }
        for(Patient p : patientList){
            System.out.println(p);
        }

        int numberOfChildren = manipulatePatients.getNumberOfPatientsByAgeGroup(0,1);
        int numberOfPupils = manipulatePatients.getNumberOfPatientsByAgeGroup(1,7);
        int numberofStudents = manipulatePatients.getNumberOfPatientsByAgeGroup(7,18);
        int numberOfAdults = manipulatePatients.getNumberOfPatientsByAgeGroup(18,85);

        System.out.println("Children (0-1): "+numberOfChildren);
        System.out.println("Pupil (1-7): "+numberOfPupils);
        System.out.println("Student (7-18): "+numberofStudents);
        System.out.println("Adults (>18): "+numberOfAdults);

        FileWrite.writeToFile("doctors", doctorList);
        FileWrite.writeToFile("patients", patientList);

        Simulator simulator = new Simulator();
        simulator.simulate(doctorList,patientList,720);
    }
}
