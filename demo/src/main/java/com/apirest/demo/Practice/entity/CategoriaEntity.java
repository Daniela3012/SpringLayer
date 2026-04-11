package com.apirest.demo.Practice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class CategoriaEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nombre;
    private String descripcion;
    private double popularidad;

    @ManyToMany()
    @JoinTable(
            name = "categoria_articulo",
            joinColumns = @JoinColumn(name = "id_categoria_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_articulo_fk")
    )
    private ArrayList<ArticuloEntity> articulos;
}
