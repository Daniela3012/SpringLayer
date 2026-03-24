package com.apirest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/basic")
public class BasicController {
    @GetMapping("/hola")
    public String method1 () {
        return "Hola Mundo";
    }

    @GetMapping("/adios")
    public String method2 () {
        return "Adios al servidor";
    }
}
