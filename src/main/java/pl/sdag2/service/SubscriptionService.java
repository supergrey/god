package pl.sdag2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdag2.entity.Subscription;
import pl.sdag2.entity.User;
import pl.sdag2.repository.SubscriptionRepository;

import java.util.List;

@Service
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<User> getAll() {
        return subscriptionRepository.findAll();
    }

    public void createSubscription(User user, Subscription subscription) {
        if (user.getLogin() == null ) {
            IllegalArgumentException exception = new IllegalArgumentException("Nie znaleziono użytkownika");
            log.error("Błąd tworzenia subskrypcji", exception);
        } if (user.getEmail() == null) {
            IllegalArgumentException exception2 = new IllegalArgumentException("Nie znaleziono adresu e-mail");
            log.error("Błąd tworzenia subskrypcji", exception2);
        } if (subscription.getId() != null) {
            IllegalArgumentException exception3 = new IllegalArgumentException("Zadana subskrypcja już istnieje");
            log.error("Błąd tworzenia subskrypcji", exception3);
        }
        subscriptionRepository.save(user);
        log.info("Pomyślnie uzyskano subskrypcję!: " + subscription.getId());
    }
}
