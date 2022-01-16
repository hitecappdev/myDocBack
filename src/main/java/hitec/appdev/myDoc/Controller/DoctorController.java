package hitec.appdev.myDoc.Controller;


import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String add(@RequestBody Doctor doctor){
        doctorService.saveDoctor(doctor);
        return "New Doctor has been added !";
    }

    @PostMapping("/login")
    public String signIn(@RequestBody Doctor doctor){
        List<Doctor> data = doctorService.getAllDoctors();

        for (Doctor oth : data) {
            if (doctor.equals(oth)) {
                return "Your are LogIn successfully";
            }else if (doctor.getEmail().equals(oth.getEmail())){
                return "Incorrect Password ! try again";
            }
        }
        return "Email Not Found ! please try to SignUP";
    }

    @GetMapping("/allDoctors")
    public List<Doctor> getAllDoctors(){
        return  doctorService.getAllDoctors();
    }
}
