package hitec.appdev.myDoc.Controller;


import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Model.Patient;
import hitec.appdev.myDoc.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/add")
    public String add(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return "New Doctor has been added !";
    }
    @PostMapping("/login")
    public String signIn(@RequestBody Patient patient){
        List<Patient> data = patientService.getAllPatients();

        for (Patient oth : data) {
            if (patient.equals(oth)) {
                return "Your are LogIn successfully";
            }else if (patient.getEmail().equals(oth.getEmail())){
                return "Incorrect Password ! try again";
            }
        }
        return "Email Not Found ! please try to SignUP";
    }
    @GetMapping("/allPatients")
    public List<Patient> getAllPatient(){
        return  patientService.getAllPatients();
    }
    @PostMapping("/getPat")
    public Patient getPatient(@RequestBody String email){
        return  patientService.getPatient(email);
    }
    @PostMapping("/editPat")
    public Patient editPatient(@RequestBody Patient patient){
            patientService.EditPatient(patient.getEmail(),patient.getGender(),
                    patient.getHeight(),patient.getWeight(),patient.isDiabetic());
        return  patientService.getPatient(patient.getEmail());
    }
}
