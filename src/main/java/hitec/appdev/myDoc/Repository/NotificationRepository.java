package hitec.appdev.myDoc.Repository;

import hitec.appdev.myDoc.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

    @Query("SELECT s from Notification s WHERE s.message = ?1")
    Optional<Notification> findNotificationByMessage(String message);

}
