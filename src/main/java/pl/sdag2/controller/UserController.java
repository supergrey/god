package pl.sdag2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.sdag2.entity.User;
import pl.sdag2.entity.Wallet;
import pl.sdag2.service.UserService;
import pl.sdag2.service.WalletService;

import java.util.List;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;
    private final WalletService walletService;
//    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
//        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/login")
//    public String getLoginForm() {
//        return "user-register";
//    }

    @GetMapping("/all")
    public String getList(ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("users", users);
//        users.stream().forEach(user -> {log.info(user.getUserType().name());});
        return "/user/all";
    }

    @GetMapping("/add")
    public String getForm(
            @ModelAttribute("user") User user, @ModelAttribute("wallet") Wallet wallet
    ) {
        return "user/form";
    }

    @PostMapping("/add")
    public String postForm(@Validated User user, BindingResult bindingResult) {
        Wallet wallet = new Wallet();
        walletService.create(wallet);
        user.setWallet(wallet);

        try {
            UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            if (userDetails.getUsername() != null) {
                FieldError fieldError = new FieldError(
                        "user",
                        "login",
                        "Użytkownik o takiej nazwie już istnieje"
                );
                bindingResult.addError(fieldError);
            }
        }
        catch (UsernameNotFoundException e) {
            log.info(e.getMessage());
        }
        if (bindingResult.hasErrors()) {
            return "/user/form";
        }
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
