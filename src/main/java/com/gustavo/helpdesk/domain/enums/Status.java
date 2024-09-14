package com.gustavo.helpdesk.domain.enums;

public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descrico;

    Status(Integer codigo, String descrico) {
        this.codigo = codigo;
        this.descrico = descrico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrico() {
        return descrico;
    }

    public static Status toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(Status x : Status.values()){
            if(cod.equals((x.getCodigo()))){
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido.");
    }
}
