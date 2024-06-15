package com.github.brunobuttros.bff.controller;

import com.github.brunobuttros.bff.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService authService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            String token = authService.authenticate(username, password);
            model.addAttribute("token", token);
            return "redirect:/lista";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Authentication failed: " + e.getMessage());
            return "login";
        }
    }
}
