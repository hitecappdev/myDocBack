package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Model.Notification;
import hitec.appdev.myDoc.Repository.DoctorRepository;
import hitec.appdev.myDoc.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
       Doctor doc = doctorRepository.findDoctorByEmail(doctor.getEmail());

        if(doc!= null){
            throw  new IllegalStateException("This address e-mail already exist !");
        }

        return doctorRepository.save(doctor);
    }
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Notification Notify(Notification notification) {
        Optional<Notification> not = notificationRepository.findNotificationByMessage(notification.getMessage());
        if(not.isPresent()){
            throw  new IllegalStateException("This address e-mail already exist !");
        }
        return notificationRepository.save(notification);
    }

    @Override
    public void EditDoctor(String gender, String speciality, String adress, String email) {
        doctorRepository.EditDoctor(gender,speciality,adress,email);
    }

    @Override
    public Doctor getDoctor(String email) {
        return doctorRepository.findDoctorByEmail(email);
    }
}
