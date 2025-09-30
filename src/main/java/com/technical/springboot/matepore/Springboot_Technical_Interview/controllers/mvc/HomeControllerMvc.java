package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.mvc;

import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.PersonDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.dto.WalletDto;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.PersonService;
import com.technical.springboot.matepore.Springboot_Technical_Interview.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeControllerMvc {

    private final PersonService personService;
    private final WalletService walletService;

    // Homepage
    @GetMapping("/")
    public String index() {
        return "index"; // Renders index.html
    }

    // Search handler
    @GetMapping("/search")
    public String search(@RequestParam(name = "q", required = false) String query, Model model) {
        // Búsqueda de personas (por nombre)
        List<PersonDto> persons = personService.list().stream()
                .filter(p -> query != null && p.getName() != null &&
                        p.getName().toLowerCase().contains(query.toLowerCase()))
                .toList();

        // Búsqueda de wallets (por id, salario o salario en dólares)
        List<WalletDto> wallets = walletService.list().stream()
                .filter(w -> query != null && (
                        (w.getId() != null && String.valueOf(w.getId()).contains(query)) ||
                                (w.getSalary() != null && String.valueOf(w.getSalary()).contains(query)) ||
                                (w.getSalaryInDollars() != null && String.valueOf(w.getSalaryInDollars()).contains(query))
                ))
                .toList();

        model.addAttribute("persons", persons);
        model.addAttribute("wallets", wallets);
        model.addAttribute("query", query);

        return "search-results"; // Necesitarías crear search-results.html
    }
}
