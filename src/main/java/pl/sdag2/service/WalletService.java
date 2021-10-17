package pl.sdag2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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
    }
}
