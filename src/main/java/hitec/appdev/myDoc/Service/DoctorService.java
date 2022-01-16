package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Doctor;

import java.util.List;

public interface DoctorService {

    public Doctor saveDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();
}
