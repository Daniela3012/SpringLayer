package com.apirest.demo.Practice.controller;

import com.apirest.demo.Practice.dto.CategoriaResponseDTO;
import com.apirest.demo.Practice.dto.CategoriaCreateDTO;
import com.apirest.demo.Practice.service.CategoriaService;
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
