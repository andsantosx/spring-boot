package com.spring_boot.api.mappers;

import com.spring_boot.api.domain.Chamado;
import com.spring_boot.api.domain.Cliente;
import com.spring_boot.api.domain.Tecnico;
import com.spring_boot.api.domain.enums.Prioridade;
import com.spring_boot.api.domain.enums.Status;
import com.spring_boot.api.dtos.ChamadoDTO;
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
public class ChamadoMapperImpl implements ChamadoMapper {

    @Override
    public ChamadoDTO toDTO(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }

        ChamadoDTO chamadoDTO = new ChamadoDTO();

        chamadoDTO.setPrioridade( chamadoPrioridadeCodigo( chamado ) );
        chamadoDTO.setStatus( chamadoStatusCodigo( chamado ) );
        chamadoDTO.setTecnico( chamadoTecnicoId( chamado ) );
        chamadoDTO.setCliente( chamadoClienteId( chamado ) );
        chamadoDTO.setNomeTecnico( chamadoTecnicoNome( chamado ) );
        chamadoDTO.setNomeCliente( chamadoClienteNome( chamado ) );
        chamadoDTO.setId( chamado.getId() );
        chamadoDTO.setDataAbertura( chamado.getDataAbertura() );
        chamadoDTO.setDataFechamento( chamado.getDataFechamento() );
        chamadoDTO.setTitulo( chamado.getTitulo() );
        chamadoDTO.setObservacoes( chamado.getObservacoes() );

        return chamadoDTO;
    }

    @Override
    public List<ChamadoDTO> toDTOList(List<Chamado> chamados) {
        if ( chamados == null ) {
            return null;
        }

        List<ChamadoDTO> list = new ArrayList<ChamadoDTO>( chamados.size() );
        for ( Chamado chamado : chamados ) {
            list.add( toDTO( chamado ) );
        }

        return list;
    }

    private Integer chamadoPrioridadeCodigo(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Prioridade prioridade = chamado.getPrioridade();
        if ( prioridade == null ) {
            return null;
        }
        Integer codigo = prioridade.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    private Integer chamadoStatusCodigo(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Status status = chamado.getStatus();
        if ( status == null ) {
            return null;
        }
        Integer codigo = status.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    private Integer chamadoTecnicoId(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Tecnico tecnico = chamado.getTecnico();
        if ( tecnico == null ) {
            return null;
        }
        Integer id = tecnico.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer chamadoClienteId(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Cliente cliente = chamado.getCliente();
        if ( cliente == null ) {
            return null;
        }
        Integer id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String chamadoTecnicoNome(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Tecnico tecnico = chamado.getTecnico();
        if ( tecnico == null ) {
            return null;
        }
        String nome = tecnico.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String chamadoClienteNome(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }
        Cliente cliente = chamado.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String nome = cliente.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}
