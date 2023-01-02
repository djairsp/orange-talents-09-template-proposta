package com.zup.proposta.criarproposta;

import com.zup.proposta.model.Proposta;
import com.zup.proposta.util.beanvalidation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CriarPropostaRequest {

    @NotBlank
    @NotNull
    @UniqueValue(domainClass = Proposta.class, fieldName = "cpfCnpj")
    private String cpfCnpj;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String endereco;
    @NotNull
    @Positive
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
