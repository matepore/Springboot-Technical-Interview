package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.mvc;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletControllerMvc {

    private final WalletService walletService;

    @GetMapping
    public String listWallets(Model model){
        model.addAttribute("wallets", walletService.list());
        return "wallets/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("wallet", new WalletDto());
        return "wallets/form";
    }

    @PostMapping("/save")
    public String saveWallet(@ModelAttribute("wallet") WalletDto walletDto, RedirectAttributes redirectAttributes){
        walletService.create(walletDto);
        redirectAttributes.addFlashAttribute("success", "Wallet created successfully!");
        return "redirect:/wallets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        WalletDto walletDto = walletService.findById(id);
        model.addAttribute("wallet", walletDto);
        return "wallets/form";
    }

    @PostMapping("/update/{id}")
    public String updateWallet(@PathVariable Long id, @ModelAttribute("wallet") WalletDto walletDto, RedirectAttributes redirectAttributes) {
        walletService.update(id, walletDto);
        redirectAttributes.addFlashAttribute("success", "Wallet updated successfully!");
        return "redirect:/wallets";
    }

    @GetMapping("/delete/{id}")
    public String deleteWallet(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        walletService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Wallet deleted successfully!");
        return "redirect:/wallets";
    }
}
