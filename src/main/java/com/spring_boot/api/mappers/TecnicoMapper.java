package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Tecnico;
import com.spring_boot.api.dtos.TecnicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    Tecnico toEntity(TecnicoDTO dto);

    TecnicoDTO toDTO(Tecnico entity);

    List<TecnicoDTO> toDTOList(List<Tecnico> entityList);

    /**
     * Atualiza uma entidade existente (@MappingTarget) com os dados de um DTO.
     * Isso evita criar uma nova instância e preserva o estado da entidade gerenciada.
     */
    void updateEntityFromDto(TecnicoDTO dto, @MappingTarget Tecnico entity);
}
