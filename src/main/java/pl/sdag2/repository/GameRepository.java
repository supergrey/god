package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sdag2.entity.Game;

import java.math.BigDecimal;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Modifying
    @Query("update Game g set g.title = ?1, g.priceFor24h = ?2 where g.id = ?3")
    void edit(String title, BigDecimal priceFor24h, Long id);

}
