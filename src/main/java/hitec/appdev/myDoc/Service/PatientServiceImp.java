package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Model.Patient;
import hitec.appdev.myDoc.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService{

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient savePatient(Patient patient) {
        Optional<Patient> doc = patientRepository.findPatientByEmail(patient.getEmail());

        if(doc.isPresent()){
            throw  new IllegalStateException("This address e-mail already exist !");
        }

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
