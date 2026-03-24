package com.apirest.demo.repository;

import com.apirest.demo.entity.ArticuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticuloRepository extends JpaRepository<ArticuloEntity, UUID> {

}
