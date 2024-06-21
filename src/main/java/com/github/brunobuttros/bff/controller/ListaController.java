package com.github.brunobuttros.bff.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.brunobuttros.bff.dto.UserListDTO;
import com.github.brunobuttros.bff.service.ListaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListaController {

    private final ListaService listaService;

    @Autowired
    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping("/lista")
    public String listarNomesEScores(Model model, HttpSession session) {
        try {
            List<UserListDTO> userScores = listaService.getAllUserScores(session);
            ObjectMapper mapper = new ObjectMapper();
            model.addAttribute("userScores", mapper.writeValueAsString(userScores));
            return "lista";
        } catch (ErrorResponseException erx) {
            if (erx.getStatusCode().is4xxClientError());
            return "login";
        } catch (Exception e) {
            model.addAttribute("error.jsp", "Failed to retrieve user scores: " + e.getMessage());
            return "error";
        }
    }
}
