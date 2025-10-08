package com.spring_boot.api.dtos;

import com.spring_boot.api.domain.Cliente;
import com.spring_boot.api.domain.enums.Perfil;
import jakarta.validation.constraints.NotNull;

import java.util.stream.Collectors;

public class ClienteDTO extends PessoaDTO {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "O campo SENHA é requerido")
    protected String senha;

    public ClienteDTO() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
