package hitec.appdev.myDoc.Repository;

import hitec.appdev.myDoc.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query("SELECT s from Patient s WHERE s.name = ?1")
    Optional<Patient> findPatientByName(String name);

    @Query("SELECT s from Patient s WHERE s.email = ?1")
    Patient findPatientByEmail(String email);

    @Modifying
    @Query("update Patient u set u.gender = ?1, u.height = ?2, u.weight = ?3, u.diabetic = ?4 where u.email = ?5")
    void EditPatient(String gender, String height, String weight,boolean diabetic, String email );
}
