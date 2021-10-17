package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdag2.entity.User;
import pl.sdag2.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getList(ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
        return "/user/all";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("user") User user) {
        return "/user/add";
    }

    @PostMapping("/add")
    public String postForm(User user) {
        userService.create(user);
        return "redirect:/user/all";
    }
}
