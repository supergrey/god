package pl.sdag2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdag2.entity.Game;
import pl.sdag2.repository.GameRepository;

import java.util.List;

@Service
@Slf4j
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public void create(Game game) {
        if(game.getId() != null) {
            IllegalArgumentException ex = new IllegalArgumentException("Gra o zadanym identyfikatorze już istnieje");
            log.error("Błąd zapisu gry");
            throw ex;
        }
        gameRepository.save(game);
    }
}
