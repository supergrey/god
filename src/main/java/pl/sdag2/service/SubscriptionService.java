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
}
