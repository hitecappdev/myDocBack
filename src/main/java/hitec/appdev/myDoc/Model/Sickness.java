package hitec.appdev.myDoc.Model;


import javax.persistence.*;

@Entity
@Table(name = "Sickness")
public class Sickness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String ownerMail;



}
