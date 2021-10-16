package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdag2.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
