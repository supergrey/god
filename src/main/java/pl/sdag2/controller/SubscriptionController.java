package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdag2.entity.Subscription;
import pl.sdag2.service.GameService;
import pl.sdag2.service.SubscriptionService;

import java.util.List;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/all")
    public String getList(ModelMap modelMap) {
        List<Subscription> subscriptions = subscriptionService.getAll();
        modelMap.addAttribute("subscriptions", subscriptions);
        return "/subscription/all";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("subscription") Subscription subscription) {
        return "/subscription/add";
    }

    @PostMapping("/add")
    public String postForm(Subscription subscription) {
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