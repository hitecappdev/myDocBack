package hitec.appdev.myDoc.Service;

import hitec.appdev.myDoc.Model.Patient;

import java.util.List;

public interface PatientService {

    public Patient savePatient(Patient patient);

    public List<Patient> getAllPatients();
}
