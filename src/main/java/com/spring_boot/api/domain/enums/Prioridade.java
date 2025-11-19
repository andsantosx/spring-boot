package com.spring_boot.api.domain.enums;

public enum Prioridade {
    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Prioridade x : Prioridade.values()) {
            if (cod.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida: " + cod);
    }

    public static Prioridade toEnum(String desc) {
        if (desc == null) {
            return null;
        }
        for (Prioridade x : Prioridade.values()) {
            if (desc.equalsIgnoreCase(x.getDescricao())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida: " + desc);
    }
}
