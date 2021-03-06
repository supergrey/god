package pl.sdag2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdag2.entity.Game;

import java.math.BigDecimal;

public interface GameRepository extends JpaRepository<Game, Long> {

}
