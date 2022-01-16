package hitec.appdev.myDoc.Repository;

import hitec.appdev.myDoc.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query("SELECT s from Patient s WHERE s.name = ?1")
    Optional<Patient> findPatientByName(String name);

    @Query("SELECT s from Patient s WHERE s.email = ?1")
    Optional<Patient> findPatientByEmail(String email);
}
