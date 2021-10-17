package pl.sdag2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
