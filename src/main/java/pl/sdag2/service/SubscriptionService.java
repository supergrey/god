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

    public List<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    public void createSubscription(Subscription subscription) {
        if (subscription.getUser() == null) {
            IllegalArgumentException ex = new IllegalArgumentException("Nie znaleziono użytkownika");
            log.error("Błąd tworzenia subskrypcji", ex);
        } if (subscription.getGame() == null) {
            IllegalArgumentException ex = new IllegalArgumentException("Gra nie istnieje. Subskrypcja musi być przypisanan do użytkownika i gry.");
            log.error("Błąd tworzenia subskrypcji", ex);
        }
            subscriptionRepository.save(subscription);
            log.info("Pomyślnie uzyskano subskrypcję!" + subscription.getId());
        }
    /*
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
        subscriptionRepository.save(subscription);
        log.info("Pomyślnie uzyskano subskrypcję!: " + subscription.getId());
    }
*/
        public void update (Subscription subscription) {
            if (subscription.getId() == null) {
                IllegalArgumentException ex = new IllegalArgumentException("Zadana subskrypcja nie istnieje");
                log.error("Błąd edycji subskrypcji", ex);
            }
            subscriptionRepository.save(subscription);
            log.info("Pomyślnie edytowano subskrypcje" + subscription.getId());
        }

        public void deleteById (Long id) {
            if (subscriptionRepository.findById(id).isEmpty()) {
                IllegalArgumentException ex = new IllegalArgumentException("Nie znaleziono subskrypcji o zadanym ID");
                log.error("Błąd usuwania subskrypcji", ex);
            }
            subscriptionRepository.deleteById(id);
            log.info("Usunięto subskrypcję o ID: " + id);
        }

        public Subscription getById (Long id) {
            if (subscriptionRepository.findById(id).isEmpty()) {
                IllegalArgumentException ex = new IllegalArgumentException("Nie znaleziono subskrypcji o zadanym ID");
                log.error("Nie znaleziono subskrypcji", ex);
            }
            return subscriptionRepository.findById(id).get();
        }

}
