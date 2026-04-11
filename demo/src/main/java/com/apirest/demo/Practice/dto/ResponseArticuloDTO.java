package com.apirest.demo.Practice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseArticuloDTO {
    private UUID id;
    private String titulo;
    private String contenido;
    private String url;
}
