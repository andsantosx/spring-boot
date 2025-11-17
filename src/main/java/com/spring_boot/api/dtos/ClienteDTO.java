package com.spring_boot.api.dtos;

import br.com.caelum.stella.bean.validation.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotBlank(message = "O campo NOME é requerido")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    protected String nome;

    @CPF(message = "CPF inválido")
    @NotBlank(message = "O campo CPF é requerido")
    protected String cpf;

    @NotBlank(message = "O campo EMAIL é requerido")
    @Email(message = "Formato de e-mail inválido")
    protected String email;

    @NotBlank(message = "O campo SENHA é requerido")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    protected String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDTO() {
        super();
    }

    // Getters e Setters ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
