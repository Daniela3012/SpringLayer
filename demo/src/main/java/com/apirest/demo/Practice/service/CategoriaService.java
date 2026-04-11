package com.apirest.demo.Practice.service;

import com.apirest.demo.Practice.dto.CategoriaCreateDTO;
import com.apirest.demo.Practice.dto.CategoriaResponseDTO;
import com.apirest.demo.Practice.entity.CategoriaEntity;
import com.apirest.demo.Practice.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //guardar categoria
    public CategoriaResponseDTO saveCategoria (@RequestBody CategoriaCreateDTO dto) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        categoriaRepository.save(categoria);

        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO();
        categoriaResponseDTO.setNombre(categoria.getNombre());
        categoriaResponseDTO.setDescripcion(categoria.getDescripcion());
        categoriaResponseDTO.setPopularidad(categoria.getPopularidad());

        return categoriaResponseDTO;
    }
}
