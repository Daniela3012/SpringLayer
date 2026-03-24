package com.apirest.demo.dto;

import com.apirest.demo.entity.ArticuloEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDTO {
    private UUID id;
    private String nombre;
    private String descripcion;
    private double popularidad;

    //articulos en los que categoria esta presente
}
