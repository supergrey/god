package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sdag2.entity.User;

import java.util.Date;

public interface SubscriptionRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("update Subscription s set s.id = ?1, s.user = ?2, s.game = ?3, s.expireDate = ?4")
    void edit (Long id, String user, String game, Date expireDate);
}
