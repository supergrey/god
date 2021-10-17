package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdag2.service.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public String getAll(){
        return "list";
    }

}
