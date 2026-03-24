package com.apirest.demo.service;

import com.apirest.demo.dto.UsuarioCreateDTO;
import com.apirest.demo.dto.UsuarioResponseDTO;
import com.apirest.demo.entity.UsuarioEntity;
import com.apirest.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO saveUsuario(UsuarioCreateDTO dto) {
        String nombres = dto.getNombres().toUpperCase();
        String apellidos = dto.getApellidos().toUpperCase();
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setEmail(dto.getEmail());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setSexo(dto.getSexo());
        usuario.setDni(dto.getDni());

        usuarioRepository.save(usuario);
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNombres(usuario.getNombres());
        usuarioResponseDTO.setApellidos(usuario.getApellidos());
        usuarioResponseDTO.setUsername(usuario.getUsername());
        usuarioResponseDTO.setSexo(usuario.getSexo());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        usuarioResponseDTO.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioResponseDTO.setNumComentarios(0);

        return usuarioResponseDTO;
    }
}
