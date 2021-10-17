package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdag2.entity.User;

public interface SubscriptionRepository extends JpaRepository<User, Long> {
}
