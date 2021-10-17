package pl.sdag2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdag2.entity.Game;
import pl.sdag2.service.GameService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/game")
public class GameController {
private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public String getAll(ModelMap modelMap){
        List<Game> games = gameService.getAll();
        modelMap.addAttribute("games",games);
        return "game/all";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("game") Game game){
        return "game/add";
    }

    @PostMapping("/add")
    public  String addGame(Game game){
        log.info("Otrzymano dane: " + game.getTitle() + ", " + game.getPrice());
        gameService.create(game);
        return "redirect:/game/all";
    }
}
