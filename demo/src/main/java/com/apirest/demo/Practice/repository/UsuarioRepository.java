package com.apirest.demo.Practice.repository;

import com.apirest.demo.Practice.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

    @Query(value = "SELECT * FROM usuario WHERE username = :username", nativeQuery = true)
    public Optional<UsuarioEntity> findByUserName (String username);

    @Query(value = "SELECT * FROM usuario WHERE fecha_nacimiento = :fechaNacimiento", nativeQuery = true)
    public List<UsuarioEntity> findByFechaNacimientoAfter (Date fechaNacimiento);
}
