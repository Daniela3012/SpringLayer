package com.apirest.demo.service;

import com.apirest.demo.dto.ResponseArticuloDTO;
import com.apirest.demo.dto.UsuarioCreateDTO;
import com.apirest.demo.dto.UsuarioResponseDTO;
import com.apirest.demo.entity.ArticuloEntity;
import com.apirest.demo.entity.UsuarioEntity;
import com.apirest.demo.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public UsuarioResponseDTO saveUsuario(UsuarioCreateDTO dto) {
        dto.setNombres(dto.getNombres().toUpperCase());
        dto.setApellidos(dto.getApellidos().toUpperCase());

        UsuarioEntity usuario = new UsuarioEntity();
        modelMapper.map(dto, usuario);
        usuarioRepository.save(usuario);

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        modelMapper.map(usuario, usuarioResponseDTO);
        return usuarioResponseDTO;
    }

    public UsuarioResponseDTO findById (UUID id) {
        Optional<UsuarioEntity> usuarioEntityOptional = usuarioRepository.findById(id);
        if (usuarioEntityOptional.isEmpty()) {
            return null;
        }
        UsuarioEntity usuario = usuarioEntityOptional.get();
        List<ArticuloEntity> articulos = usuario.getArticulos();
        List<ResponseArticuloDTO> responseArticuloDTOS = articulos.stream().map(
                articuloEntity -> {
                    ResponseArticuloDTO responseArticuloDTO = new ResponseArticuloDTO();
                    modelMapper.map(articuloEntity, responseArticuloDTO);
                    return responseArticuloDTO;
                }).toList();
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setArticuloDTOS(responseArticuloDTOS);
        modelMapper.map(usuario, usuarioResponseDTO);
        return usuarioResponseDTO;
    }
}
