package com.apirest.demo.repository;

import com.apirest.demo.dto.UsuarioCreateDTO;
import com.apirest.demo.entity.ArticuloEntity;
import com.apirest.demo.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

}
