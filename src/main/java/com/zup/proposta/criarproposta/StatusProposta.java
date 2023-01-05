package com.zup.proposta.criarproposta;

public enum StatusProposta {
    ELEGIVEL("ELEGIVEL","elegivel", "SEM_RESTRICAO"),
    NAO_ELEGIVEL("NAO_ELEGIVEL","nao elegivel", "COM_RESTRICAO");

    private String estado;
    private String value;
    private String compare;

    StatusProposta(String estado, String value, String compare){
        this.estado = estado;
        this.value = value;
        this.compare = compare;
    }


    public static String tipoRestricao(String value){
        if(ELEGIVEL.compare.equals(value)){
            return ELEGIVEL.estado;
        }
        return NAO_ELEGIVEL.estado;
    }
}
