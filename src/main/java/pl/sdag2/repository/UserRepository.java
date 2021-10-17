package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sdag2.entity.User;
import pl.sdag2.entity.UserType;

public interface UserRepository extends JpaRepository<User, Long> {

}
