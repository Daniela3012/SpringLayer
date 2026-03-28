package com.apirest.demo.controller;

import com.apirest.demo.dto.UsuarioCreateDTO;
import com.apirest.demo.dto.UsuarioResponseDTO;
import com.apirest.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
