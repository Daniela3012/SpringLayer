package com.apirest.demo.service;

import com.apirest.demo.dto.CreateArticuloDTO;
import com.apirest.demo.dto.ResponseArticuloDTO;
import com.apirest.demo.entity.ArticuloEntity;
import com.apirest.demo.entity.UsuarioEntity;
import com.apirest.demo.repository.ArticuloRepository;
import com.apirest.demo.repository.UsuarioRepository;

import java.util.UUID;

public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public ResponseArticuloDTO createArticulo (CreateArticuloDTO dto) {
        UUID idUsuario = dto.getUsuarioId();
        UsuarioEntity usuario = articuloRepository.findById(idUsuario);
    }
}
