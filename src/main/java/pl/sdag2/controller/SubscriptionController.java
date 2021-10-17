package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdag2.entity.Subscription;
import pl.sdag2.entity.User;
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
}
