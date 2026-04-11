package com.apirest.demo.Practice.service;

import com.apirest.demo.Practice.dto.CreateArticuloDTO;
import com.apirest.demo.Practice.dto.ResponseArticuloDTO;
import com.apirest.demo.Practice.entity.ArticuloEntity;
import com.apirest.demo.Practice.entity.UsuarioEntity;
import com.apirest.demo.Practice.repository.ArticuloRepository;
import com.apirest.demo.Practice.repository.UsuarioRepository;
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

    public ResponseArticuloDTO findById (UUID id) {
        Optional<ArticuloEntity> articuloEntityOptional = articuloRepository.findById(id);
        if (articuloEntityOptional.isEmpty()) {
            return null;
        }
        ArticuloEntity articulo = articuloEntityOptional.get();
        ResponseArticuloDTO articuloDTO = new ResponseArticuloDTO();
        articuloDTO.setId(articulo.getId());
        articuloDTO.setContenido(articulo.getContenido());
        articuloDTO.setUrl(articulo.getUrl());

        return articuloDTO;

    }
}
