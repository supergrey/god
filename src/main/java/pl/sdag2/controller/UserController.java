package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
        return "user/form";
    }

    @PostMapping("/add")
    public String postForm(User user) {
        userService.create(user);
        return "redirect:/user/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/user/all";
    }

    @GetMapping("/{id}")
    public String get(ModelMap modelMap, @PathVariable Long id) {
        User user = userService.getById(id);
        modelMap.addAttribute("user", user);
        return "/user/show";
    }

    @GetMapping("/{id}/edit")
    public String editGetForm(ModelMap modelMap, @PathVariable Long id) {
        User user = userService.getById(id);
        modelMap.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/{id}/edit")
    public String editPostForm(User user) {
        userService.update(user);
        return "redirect:/user/all";
    }
}
