package com.zup.proposta.criarproposta;

import com.zup.proposta.model.Proposta;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("proposta")
public class CriarPropostaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String criarProposta(@RequestBody @Valid CriarPropostaRequest request, ServletUriComponentsBuilder uriComponentsBuilder){
        Proposta proposta = request.getModel();
        entityManager.persist(proposta);
        return urlProposta(proposta, uriComponentsBuilder);
    }

    private String urlProposta(Proposta proposta, ServletUriComponentsBuilder uriComponentsBuilder){
        String urlRetornoPagSeguro = uriComponentsBuilder.path("/proposta/{id}")
                .buildAndExpand(proposta.getId()).toString();
        return urlRetornoPagSeguro;
    }

}
