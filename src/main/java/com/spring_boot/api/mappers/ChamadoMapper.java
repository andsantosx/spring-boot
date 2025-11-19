package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Chamado;
import com.spring_boot.api.dtos.ChamadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    @Mapping(source = "prioridade.descricao", target = "prioridade")
    @Mapping(source = "status.descricao", target = "status")
    @Mapping(source = "tecnico.id", target = "tecnico")
    @Mapping(source = "cliente.id", target = "cliente")
    @Mapping(source = "tecnico.nome", target = "nomeTecnico")
    @Mapping(source = "cliente.nome", target = "nomeCliente")
    ChamadoDTO toDTO(Chamado chamado);

    List<ChamadoDTO> toDTOList(List<Chamado> chamados);
}
