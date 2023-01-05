package com.zup.proposta.solicitacaoanalise;

public class ResultadoAnalise {

    public String documento;
    public String nome;
    public String resultadoSolicitacao;

    @Override
    public String toString() {
        return "ResultadoAnalise{" +
                "resultadoSolicitacao='" + resultadoSolicitacao + '\'' +
                '}';
    }

    public String getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }
}
