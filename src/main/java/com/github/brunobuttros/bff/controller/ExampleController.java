package com.github.brunobuttros.bff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("mensagem", "impossível carregar o login.");
        return "brunoteste";
    }
}
