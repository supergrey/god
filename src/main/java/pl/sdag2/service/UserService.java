package pl.sdag2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdag2.entity.User;
import pl.sdag2.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void create(User user) {
        if (user.getId() != null) {
            IllegalArgumentException ex = new IllegalArgumentException("Użytkownik o zadanym identyfikatorze już istnieje");
            log.error("Błąd zapisu użytkownika", ex);
        }
        userRepository.save(user);
        log.info("Utworzono użytkownika: " + user.getLogin());
    }

    public void update(User user) {
        if (user.getId() == null) {
            IllegalArgumentException ex = new IllegalArgumentException("Użytkownik o zadanym identyfikatorze nie istnieje");
            log.error("Nie udało sie edytować użytkownika", ex);
        }
        userRepository.edit(user.getLogin(), user.getPassword(), user.getEmail(), user.getUserType(), user.getId());
        log.info("Edytowano użytkownika: " + user.getLogin());
    }

    public void deleteById(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            IllegalArgumentException ex = new IllegalArgumentException("Użytkownik o zadanym identyfikatorze nie istnieje");
            log.error("Błąd usuwania użytkownika", ex);
        }
        userRepository.deleteById(id);
        log.info("Usunięto użytkownika o identyfikatorze: " + id);
    }
}
