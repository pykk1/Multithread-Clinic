package doctor.clinic;

import doctor.clinic.entity.Doctor;
import doctor.clinic.util.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateDoctors {
    private final List<Doctor> doctorsList = new ArrayList<>();

    public List<Doctor> generateListOfDoctors(int numberOfDoctors, int minimumAge, int maximumAge) {
        String doctorFirstName;
        String doctorLastName;
        int doctorId;
        int doctorAge;
        Doctor doctor;
        for (int i = 0; i < numberOfDoctors; i++) {
            doctorFirstName = Randoms.randomString(3);
            doctorLastName = Randoms.randomString(2);
            doctorAge = Randoms.randomInt(minimumAge, maximumAge);
            doctorId = assignId();

            doctor = new Doctor(doctorAge, doctorFirstName, doctorLastName, doctorId);
            doctorsList.add(doctor);
        }

        return this.doctorsList;
    }

    private int assignId() {
        int id;
        id = Randoms.randomInt(1000, 10000);
        for (Doctor d : doctorsList) {
            if (d.getId() == id) assignId();
        }
        return id;
    }

    public GenerateDoctors() {
    }
}
