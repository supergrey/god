package pl.sdag2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdag2.entity.Game;
import pl.sdag2.entity.Subscription;
import pl.sdag2.service.GameService;
import pl.sdag2.service.SubscriptionService;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final GameService gameService;

    public SubscriptionController(SubscriptionService subscriptionService, GameService gameService) {
        this.subscriptionService = subscriptionService;
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public String getList(ModelMap modelMap) {
        List<Subscription> subscriptions = subscriptionService.getAll();
        modelMap.addAttribute("subscriptions", subscriptions);
        return "/subscription/all";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("subscription") Subscription subscription, ModelMap modelMap) {
        List<Game> games = gameService.getAll();
        modelMap.addAttribute("games",games);
        return "/subscription/add";
    }

    @PostMapping("/add")
    public String postForm(Subscription subscription) {
        log.info("subscription: " + subscription.toString());
        subscriptionService.createSubscription(subscription);
        return "redirect:/subscription/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        subscriptionService.deleteById(id);
        return "redirect:/subscription/all";
    }

    @GetMapping("/{id}")
    public String get(ModelMap modelMap, @PathVariable Long id) {
        Subscription subscription = subscriptionService.getById(id);
        modelMap.addAttribute("subscription", subscription);
        return "/subscription/show";
    }

    @GetMapping("/{id}/edit")
    public String editGetForm(ModelMap modelMap, @PathVariable Long id) {
        Subscription subscription = subscriptionService.getById(id);
        modelMap.addAttribute("subscription", subscription);
        return "/subscription/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPostForm(Subscription subscription) {
        subscriptionService.update(subscription);
        return "redirect:/subscription/all";
    }
}