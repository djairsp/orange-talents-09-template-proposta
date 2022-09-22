package com.zup.proposta.criarproposta;

import com.zup.proposta.model.Proposta;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CriarPropostaRequest {

    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    @NotNull
    private BigDecimal salario;

    public CriarPropostaRequest(String cpfCnpj, String email, String nome, String endereco, BigDecimal salario) {
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "CriarPropostaRequest{" +
                "cpfCnpj='" + cpfCnpj + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                '}';
    }

    public Proposta getModel(){
        return new Proposta(this.nome, this.email, this.endereco, this.salario, this.cpfCnpj);
    }
}
