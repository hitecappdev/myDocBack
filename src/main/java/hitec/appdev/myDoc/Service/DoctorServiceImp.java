package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Optional<Doctor> doc = doctorRepository.findDoctorByEmail(doctor.getEmail());

        if(doc.isPresent()){
            throw  new IllegalStateException("This address e-mail already exist !");
        }

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

}
