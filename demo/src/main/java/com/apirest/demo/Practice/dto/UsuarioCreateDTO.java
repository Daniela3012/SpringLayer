package com.apirest.demo.Practice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioCreateDTO {
    private String nombres;
    private String apellidos;
    private String username;
    private String password;
    private String email;
    private Date fechaNacimiento;
    private char sexo;
    private String dni;
}
