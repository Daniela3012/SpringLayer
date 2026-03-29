package com.apirest.demo.mapper;

import ch.qos.logback.core.model.Model;
import com.apirest.demo.dto.ResponseArticuloDTO;
import com.apirest.demo.dto.UsuarioCreateDTO;
import com.apirest.demo.dto.UsuarioResponseDTO;
import com.apirest.demo.entity.ArticuloEntity;
import com.apirest.demo.entity.UsuarioEntity;
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
