package com.spring_boot.api.dtos;

import com.spring_boot.api.domain.Tecnico;
import com.spring_boot.api.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;

import java.util.stream.Collectors;

public class TecnicoDTO extends PessoaDTO {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;

    public TecnicoDTO() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    public TecnicoDTO(Tecnico obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.TECNICO);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
