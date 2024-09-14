package com.gustavo.helpdesk.domain.enums;

public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer codigo;
    private String descrico;

    Prioridade(Integer codigo, String descrico) {
        this.codigo = codigo;
        this.descrico = descrico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrico() {
        return descrico;
    }

    public static Prioridade toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(Prioridade x : Prioridade.values()){
            if(cod.equals((x.getCodigo()))){
                return x;
            }
        }

        throw new IllegalArgumentException("Prioridade inválida.");
    }
}
