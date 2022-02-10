package hitec.appdev.myDoc.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Notification")
public class Notification{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senderName;
    private String gender;
    private String email;
    private String phone;
    private String receiverName;
    private Date date;
    private String message;

    public Notification() {
    }


    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String name) {
        this.senderName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
