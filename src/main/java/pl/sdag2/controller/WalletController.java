package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.sdag2.entity.Game;
import pl.sdag2.entity.User;
import pl.sdag2.entity.Wallet;
import pl.sdag2.service.WalletService;

import java.util.List;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/all")
    public String getAll(ModelMap modelMap) {
        List<Wallet> wallets = walletService.getAll();
        modelMap.addAttribute("wallets", wallets);
        return "wallet/all";
    }

    @GetMapping("/add")
    public String getForm(@ModelAttribute("wallet") Wallet wallet) {
        return "wallet/add";
    }

    @PostMapping("/add")
    public String create(Wallet wallet) {
        walletService.create(wallet);
        return "redirect:/wallet/all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, ModelMap modelMap) {
        Wallet wallet = walletService.getById(id);
        modelMap.addAttribute("wallet", wallet);
        return "wallet/get";
    }

    @GetMapping("/{id}/edit")
    public String editSingleGet(ModelMap modelMap, @PathVariable Long id) {
        Wallet wallet = walletService.getById(id);
        modelMap.addAttribute("wallet", wallet);
        return "/wallet/edit";
    }

    @PostMapping("/{id}/edit")
    public String editSinglePost(Wallet wallet) {
        walletService.update(wallet);
        return "redirect:/wallet/all";
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id){
        walletService.deleteById(id);
        return "redirect:/wallet/all";
    }

}
