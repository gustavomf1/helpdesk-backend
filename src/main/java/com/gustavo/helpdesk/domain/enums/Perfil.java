package com.gustavo.helpdesk.domain.enums;

public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

    private Integer codigo;
    private String descrico;

    Perfil(Integer codigo, String descrico) {
        this.codigo = codigo;
        this.descrico = descrico;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescrico() {
        return descrico;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(Perfil x : Perfil.values()){
            if(cod.equals((x.getCodigo()))){
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido.");
    }
}
