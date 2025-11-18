package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Cliente;
import com.spring_boot.api.dtos.ClienteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-17T21:23:35-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( dto.getId() );
        cliente.setNome( dto.getNome() );
        cliente.setCpf( dto.getCpf() );
        cliente.setEmail( dto.getEmail() );
        cliente.setSenha( dto.getSenha() );
        cliente.setDataCriacao( dto.getDataCriacao() );

        return cliente;
    }

    @Override
    public ClienteDTO toDTO(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( entity.getId() );
        clienteDTO.setNome( entity.getNome() );
        clienteDTO.setCpf( entity.getCpf() );
        clienteDTO.setEmail( entity.getEmail() );
        clienteDTO.setSenha( entity.getSenha() );
        clienteDTO.setDataCriacao( entity.getDataCriacao() );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toDTOList(List<Cliente> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( entityList.size() );
        for ( Cliente cliente : entityList ) {
            list.add( toDTO( cliente ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ClienteDTO dto, Cliente entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setNome( dto.getNome() );
        entity.setCpf( dto.getCpf() );
        entity.setEmail( dto.getEmail() );
        entity.setSenha( dto.getSenha() );
        entity.setDataCriacao( dto.getDataCriacao() );
    }
}
