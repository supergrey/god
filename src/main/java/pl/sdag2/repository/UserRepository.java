package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sdag2.entity.User;
import pl.sdag2.entity.UserType;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User u set u.login = ?1, u.password = ?2, u.email = ?3, u.userType = ?4 where u.id = ?5")
    void edit(String login, String password, String email, UserType userType, Long id);
}
