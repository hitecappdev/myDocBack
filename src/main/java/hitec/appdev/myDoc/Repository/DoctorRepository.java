package hitec.appdev.myDoc.Repository;


import hitec.appdev.myDoc.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query("SELECT s from Doctor s WHERE s.name = ?1")
    Optional<Doctor> findDoctorByName(String name);


    @Query("SELECT s from Doctor s WHERE s.email = ?1")
    Doctor findDoctorByEmail(String email);

    @Modifying
    @Query("update Doctor u set u.gender = ?1, u.speciality = ?2, u.city = ?3  where u.email = ?4")
    void EditDoctor(String gender, String speciality,String adress, String email );

}
