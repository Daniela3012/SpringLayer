package com.apirest.demo.controller;

import com.apirest.demo.dto.CreateArticuloDTO;
import com.apirest.demo.dto.ResponseArticuloDTO;
import com.apirest.demo.service.ArticuloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
