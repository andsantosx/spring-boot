package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Tecnico;
import com.spring_boot.api.dtos.TecnicoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-19T19:21:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class TecnicoMapperImpl implements TecnicoMapper {

    @Override
    public Tecnico toEntity(TecnicoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tecnico tecnico = new Tecnico();

        tecnico.setId( dto.getId() );
        tecnico.setNome( dto.getNome() );
        tecnico.setCpf( dto.getCpf() );
        tecnico.setEmail( dto.getEmail() );
        tecnico.setSenha( dto.getSenha() );
        tecnico.setDataCriacao( dto.getDataCriacao() );

        return tecnico;
    }

    @Override
    public TecnicoDTO toDTO(Tecnico entity) {
        if ( entity == null ) {
            return null;
        }

        TecnicoDTO tecnicoDTO = new TecnicoDTO();

        tecnicoDTO.setId( entity.getId() );
        tecnicoDTO.setNome( entity.getNome() );
        tecnicoDTO.setCpf( entity.getCpf() );
        tecnicoDTO.setEmail( entity.getEmail() );
        tecnicoDTO.setSenha( entity.getSenha() );
        tecnicoDTO.setDataCriacao( entity.getDataCriacao() );

        return tecnicoDTO;
    }

    @Override
    public List<TecnicoDTO> toDTOList(List<Tecnico> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TecnicoDTO> list = new ArrayList<TecnicoDTO>( entityList.size() );
        for ( Tecnico tecnico : entityList ) {
            list.add( toDTO( tecnico ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(TecnicoDTO dto, Tecnico entity) {
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
