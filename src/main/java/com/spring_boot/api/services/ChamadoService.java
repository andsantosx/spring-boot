package com.spring_boot.api.services;

import com.spring_boot.api.domain.Chamado;
import com.spring_boot.api.domain.Cliente;
import com.spring_boot.api.domain.Tecnico;
import com.spring_boot.api.domain.enums.Prioridade;
import com.spring_boot.api.domain.enums.Status;
import com.spring_boot.api.dtos.ChamadoDTO;
import com.spring_boot.api.repositories.ChamadoRepository;
import com.spring_boot.api.services.exceptions.DataIntegrityViolationException;
import com.spring_boot.api.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    @Transactional(readOnly = true)
    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO objDTO) {
        return repository.save(newChamadoFromDTO(objDTO));
    }

    public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
        Chamado oldObj = findById(id);
        updateData(oldObj, objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Chamado obj = findById(id);
        if (!obj.getStatus().equals(Status.ENCERRADO)) {
            throw new DataIntegrityViolationException("Chamados com status diferente de ENCERRADO não podem ser deletados!");
        }
        repository.deleteById(id);
    }

    private void updateData(Chamado entity, ChamadoDTO dto) {
        if (StringUtils.hasText(dto.getPrioridade())) {
            entity.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
        }
        if (StringUtils.hasText(dto.getStatus())) {
            Status newStatus = Status.toEnum(dto.getStatus());
            if (newStatus == Status.ENCERRADO && entity.getStatus() != Status.ENCERRADO) {
                entity.setDataFechamento(LocalDate.now());
            }
            entity.setStatus(newStatus);
        }
        if (StringUtils.hasText(dto.getTitulo())) {
            entity.setTitulo(dto.getTitulo());
        }
        if (StringUtils.hasText(dto.getObservacoes())) {
            entity.setObservacoes(dto.getObservacoes());
        }
        if (dto.getTecnico() != null) {
            entity.setTecnico(tecnicoService.findById(dto.getTecnico()));
        }
        if (dto.getCliente() != null) {
            entity.setCliente(clienteService.findById(dto.getCliente()));
        }
    }

    private Chamado newChamadoFromDTO(ChamadoDTO obj) {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if (obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if (Status.toEnum(obj.getStatus()) == Status.ENCERRADO) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }
}
