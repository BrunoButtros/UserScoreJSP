package com.github.brunobuttros.bff.controller;

import com.github.brunobuttros.bff.dto.UserListDTO;
import com.github.brunobuttros.bff.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaController {

    private final ListaService listaService;

    @Autowired
    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UserListDTO>> listarNomesEScores() {
        List<UserListDTO> userScores = listaService.getAllUserScores();
        return ResponseEntity.ok(userScores);
    }
}
