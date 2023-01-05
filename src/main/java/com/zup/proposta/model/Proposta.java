package com.zup.proposta.model;

import com.zup.proposta.criarproposta.StatusProposta;
import com.zup.proposta.solicitacaoanalise.ResultadoAnalise;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String identificador;
    private String statusProposta;

    @Deprecated
    public Proposta() {}

    public Proposta(String nome, String email, String endereco, BigDecimal salario, String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.identificador = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "cpfCnpj='" + cpfCnpj + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", salario=" + salario +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setStatusProposta(ResultadoAnalise resultadoAnalise) {
        Assert.notNull(resultadoAnalise, "O objeto resultadoAnalise está nulo");
        Assert.notNull(resultadoAnalise.getResultadoSolicitacao(), "O atributo resultadoAnalise está vazio");
        this.statusProposta = StatusProposta.tipoRestricao(resultadoAnalise.getResultadoSolicitacao());
    }
}
