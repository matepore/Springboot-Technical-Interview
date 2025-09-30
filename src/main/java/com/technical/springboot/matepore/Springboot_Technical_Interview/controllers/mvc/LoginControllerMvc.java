package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControllerMvc {

    // Mostrar el formulario de login
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // renderiza login.html
    }

    // Procesar login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam(value = "remember-me", required = false) String rememberMe,
                              Model model) {

        // Validación simulada: usuario = admin, password = 1234
        if ("admin".equals(username) && "1234".equals(password)) {
            // Redirigir a homepage y activar toast
            model.addAttribute("showToast", true);
            return "redirect:/?loginSuccess=true";
        } else {
            // Login incorrecto, mostrar mensaje en login.html
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }
}
