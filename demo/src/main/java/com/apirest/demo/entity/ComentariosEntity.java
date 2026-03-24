package com.apirest.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="comentarios")
@Getter
@Setter
public class ComentariosEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String contenido;
    @Column(name="fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @ManyToOne()
    @JoinColumn(name = "usuario_id_fk")
    private UsuarioEntity usuario;

    @ManyToOne()
    @JoinColumn(name = "articulo_id_fk")
    private ArticuloEntity articulo;

}
