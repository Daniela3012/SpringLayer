package com.apirest.demo.service;

import com.apirest.demo.dto.CreateArticuloDTO;
import com.apirest.demo.dto.ResponseArticuloDTO;
import com.apirest.demo.entity.ArticuloEntity;
import com.apirest.demo.entity.UsuarioEntity;
import com.apirest.demo.repository.ArticuloRepository;
import com.apirest.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;
    private final UsuarioRepository usuarioRepository;

    public ArticuloService(ArticuloRepository articuloRepository, UsuarioRepository usuarioRepository) {

        this.articuloRepository = articuloRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseArticuloDTO createArticulo (CreateArticuloDTO dto) {
        UUID idUsuario = dto.getUsuarioId();
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(idUsuario);
        Optional<ArticuloEntity> articuloEntityOptional = articuloRepository.findById(idUsuario);
        if (usuarioEntityOptional.isEmpty()) {
            return null;
        }
        UsuarioEntity usuario = usuarioEntityOptional.get();
        ArticuloEntity articulo = new ArticuloEntity();
        articulo.setTitulo(dto.getTitulo());
        articulo.setContenido(dto.getContenido());

        articulo.setUrl("www."+ dto.getTitulo()+".com");
        articulo.setUsuario(usuario);
        articuloRepository.save(articulo);

        ResponseArticuloDTO responseArticuloDTO = new ResponseArticuloDTO();
        responseArticuloDTO.setId(articulo.getId());
        responseArticuloDTO.setTitulo(articulo.getTitulo());
        responseArticuloDTO.setContenido(articulo.getContenido());
        responseArticuloDTO.setUrl(articulo.getUrl());
        return responseArticuloDTO;
    }
}
