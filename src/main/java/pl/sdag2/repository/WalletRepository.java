package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sdag2.entity.PayMethod;
import pl.sdag2.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Modifying
    @Query("update Wallet w set w.user = ?1, w.accountBalance = ?2, w.payMethod = ?3 where w.id = ?4")
    void edit(String user, int accountBalance, PayMethod payMethod, Long id);
}
