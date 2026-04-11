package com.apirest.demo.Practice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateArticuloDTO {
    private String titulo;
    private String contenido;
    private UUID usuarioId;
}
