package com.technical.springboot.matepore.Springboot_Technical_Interview.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControllerMvc {

    // Shows the login form
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // renders login.html
    }

    // Proccess login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam(value = "remember-me", required = false) String rememberMe,
                              Model model) {

        // Simulated validation: usuario = admin, password = 1234
        if ("admin".equals(username) && "1234".equals(password)) {
            // Redirects to home and shows toast
            model.addAttribute("showToast", true);
            return "redirect:/?loginSuccess=true";
        } else {
            // Incorrect Login, show the error in login.html
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }
}
