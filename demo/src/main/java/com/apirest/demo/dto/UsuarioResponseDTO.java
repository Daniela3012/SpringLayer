package com.apirest.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UsuarioResponseDTO {
    private UUID id;
    private String nombres;
    private String apellidos;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private char sexo;
    private int numComentarios;
    private List<ResponseArticuloDTO> articuloDTOS;
}
