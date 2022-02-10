package hitec.appdev.myDoc.Controller;

import hitec.appdev.myDoc.Model.Doctor;
import hitec.appdev.myDoc.Model.Notification;
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
    @PostMapping("/notify")
    public String Notify(@RequestBody Notification notification){
        doctorService.Notify(notification);
        return notification.getReceiverName() + "Get notified by :" + notification.getSenderName();
    }
    @PostMapping("/login")
    public String signIn(@RequestBody Doctor doctor){
        List<Doctor> data = doctorService.getAllDoctors();
        for (Doctor oth : data) {
            if (doctor.equals(oth)) {
                return "Your are LogIn successfully";
            }else if (doctor.getEmail().equals(oth.getEmail())){
                return "Incorrect Password ! try again";}
        }
        return "Email Not Found ! please try to SignUp";
    }
    @GetMapping("/allDoctors")
    public List<Doctor> getAllDoctors(){
        return  doctorService.getAllDoctors();
    }
    @PostMapping("/getDoc")
    public Doctor getDoctor(@RequestBody String email){
        return  doctorService.getDoctor(email);
    }
    @PostMapping("/editDoc")
    public void EditDoctor(@RequestBody Doctor doctor){
        doctorService.EditDoctor(doctor.getGender(),doctor.getSpeciality(),doctor.getCity(),doctor.getEmail());
    }
}
