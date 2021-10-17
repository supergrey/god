package pl.sdag2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdag2.entity.User;
import pl.sdag2.entity.Wallet;
import pl.sdag2.repository.WalletRepository;

import java.util.List;

@Slf4j
@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    public void create(Wallet wallet) {
        if (wallet.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException(
                    "Nowy portfel nie powinien mieć żadanego identyfikatora");
            log.error("Błąd zapisywania portfela", exception);
            throw exception;
        }
        walletRepository.save(wallet);
        log.info("Utworzono nowy portfel użytkownika: " + wallet.getUser());
    }

    public void update(Wallet wallet) {
        if (wallet.getId() == null) {
            IllegalArgumentException exception = new IllegalArgumentException(
                    "Portfel, który chcesz edytować nie istnieje");
            log.error("Błąd edycji portfela", exception);
        }
        walletRepository.save(wallet);
        log.info("Edytowano portfel użytkownika: " + wallet.getUser());
    }

    public void deleteById(Long id) {
        if (walletRepository.findById(id).isEmpty()) {
            IllegalArgumentException exception = new IllegalArgumentException(
                    "Portfel o zadanym identyfikatorze nie istnieje");
            log.error("Błąd usuwania portfela", exception);
        }
        walletRepository.deleteById(id);
        log.info("Usunięto porfel o identyfikatorze: " + id);
    }

}
