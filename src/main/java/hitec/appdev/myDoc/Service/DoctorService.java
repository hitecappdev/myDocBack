package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Model.Notification;

import java.util.List;

public interface DoctorService {

    public Doctor saveDoctor(Doctor doctor);

    public List<Doctor> getAllDoctors();

    public Notification Notify(Notification notification);

    void EditDoctor(String gender, String speciality,String adress, String email );

    Doctor getDoctor(String email);
}
