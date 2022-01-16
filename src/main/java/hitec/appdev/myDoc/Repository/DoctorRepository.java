package hitec.appdev.myDoc.Repository;


import hitec.appdev.myDoc.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query("SELECT s from Doctor s WHERE s.name = ?1")
    Optional<Doctor> findDoctorByName(String name);

    @Query("SELECT s from Doctor s WHERE s.email = ?1")
    Optional<Doctor> findDoctorByEmail(String email);

}
