package com.apirest.demo.Practice.mapper;

import com.apirest.demo.Practice.dto.ResponseArticuloDTO;
import com.apirest.demo.Practice.dto.UsuarioCreateDTO;
import com.apirest.demo.Practice.dto.UsuarioResponseDTO;
import com.apirest.demo.Practice.entity.ArticuloEntity;
import com.apirest.demo.Practice.entity.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(UsuarioEntity.class, UsuarioResponseDTO.class);

        modelMapper.createTypeMap(UsuarioCreateDTO.class, UsuarioEntity.class);

        modelMapper.createTypeMap(ArticuloEntity.class, ResponseArticuloDTO.class);

        return modelMapper;
    }
}
