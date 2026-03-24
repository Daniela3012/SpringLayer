package com.apirest.demo.controller;

import com.apirest.demo.dto.CategoriaCreateDTO;
import com.apirest.demo.dto.CategoriaResponseDTO;
import com.apirest.demo.service.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController (CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/save")
    public CategoriaResponseDTO saveCategoria(@RequestBody CategoriaCreateDTO dto) {
        return categoriaService.saveCategoria(dto);
    }
}
