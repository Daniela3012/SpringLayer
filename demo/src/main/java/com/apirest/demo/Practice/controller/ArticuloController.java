package com.apirest.demo.Practice.controller;

import com.apirest.demo.Practice.dto.CreateArticuloDTO;
import com.apirest.demo.Practice.dto.ResponseArticuloDTO;
import com.apirest.demo.Practice.service.ArticuloService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController (ArticuloService articuloService) {
        this.articuloService=articuloService;
    }

    @PostMapping("/save")
    public ResponseArticuloDTO createArticulo (@RequestBody CreateArticuloDTO createArticuloDTO) {
        return articuloService.createArticulo(createArticuloDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseArticuloDTO findById (@PathVariable UUID id) {
        return articuloService.findById(id);
    }
}
