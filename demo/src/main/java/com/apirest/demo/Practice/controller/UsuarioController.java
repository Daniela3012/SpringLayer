package com.apirest.demo.Practice.controller;

import com.apirest.demo.Practice.dto.UsuarioCreateDTO;
import com.apirest.demo.Practice.dto.UsuarioResponseDTO;
import com.apirest.demo.Practice.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public UsuarioResponseDTO saveUsuario(@RequestBody UsuarioCreateDTO dto) {
        return usuarioService.saveUsuario(dto);
    }

    @GetMapping("/find/{id}")
    public UsuarioResponseDTO findById (@PathVariable UUID id) {
        return usuarioService.findById(id);
    }
}
