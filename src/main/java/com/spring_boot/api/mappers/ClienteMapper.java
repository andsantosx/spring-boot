package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Cliente;
import com.spring_boot.api.dtos.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente entity);

    List<ClienteDTO> toDTOList(List<Cliente> entityList);

    /**
     * Atualiza uma entidade existente (@MappingTarget) com os dados de um DTO.
     * Isso evita criar uma nova instância e preserva o estado da entidade gerenciada.
     */
    void updateEntityFromDto(ClienteDTO dto, @MappingTarget Cliente entity);
}
