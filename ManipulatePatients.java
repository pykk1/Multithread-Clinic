package doctor.clinic;

import doctor.clinic.entity.Patient;
import doctor.clinic.entity.Reason;
import doctor.clinic.util.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ManipulatePatients {
    List<Patient> patientsList = new ArrayList<>();

    public List<Patient> generateListOfPatients(int numberOfPatients) {
        String patientFirstName;
        String patientLastName;
        int patientAge;
        Reason patientReason;
        Patient patient;
        populateEachCategory();
        for (int i = 0; i < numberOfPatients - 7; i++) {
            patientFirstName = Randoms.randomString(5);
            patientLastName = Randoms.randomString(4);
            patientAge = Randoms.randomInt(0, 85);

            patientReason = Randoms.randomReason();
            patient = new Patient(patientAge, patientFirstName, patientLastName, patientReason);
            patientsList.add(patient);
        }
        return patientsList;
    }

    public int getNumberOfPatientsByAgeGroup(int minimumAge, int maximumAge) {
        int patientAge;
        int number = 0;
        for (Patient p : patientsList) {
            patientAge = p.getAge();
            if (patientAge >= minimumAge && patientAge < maximumAge) number++;
        }
        return number;
    }

    private void populateEachCategory() {
        addCustomPatient(0, 1, Randoms.randomReason());
        addCustomPatient(1, 6, Randoms.randomReason());
        addCustomPatient(7, 17, Randoms.randomReason());
        addCustomPatient(18, 85, Randoms.randomReason());
        addCustomPatient(0, 85, new Reason("PRESCRIPTION",20,20));
        addCustomPatient(0, 85, new Reason("TREATMENT",40,35));
        addCustomPatient(0, 85, new Reason("CONSULTATION",30,50));
    }

    private void addCustomPatient(int minimumAge, int maximumAge, Reason reason) {
        Patient patient = new Patient();
        patient.setAge(Randoms.randomInt(minimumAge, maximumAge));
        patient.setFirstName(Randoms.randomString(5));
        patient.setLastName(Randoms.randomString(4));
        patient.setReason(reason);
        patientsList.add(patient);
    }
}
